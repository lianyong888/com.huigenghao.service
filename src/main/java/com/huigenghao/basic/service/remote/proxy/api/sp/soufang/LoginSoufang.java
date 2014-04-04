package com.huigenghao.basic.service.remote.proxy.api.sp.soufang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

/**
 * 搜房登录
 * @author loowj@loowj.com
 */
public class LoginSoufang {
	static Logger logger = Logger.getLogger(LoginSoufang.class);
	private static String loginPageUrl = "http://passport.soufun.com";
	private static String loginDoUrl = "http://passport.soufun.com/default.aspx";
	private static String loginout = "http://esf.sh.soufun.com/newsecond/usercenter/loginout.aspx";
	private static String user_order = "http://my.soufun.com/index.aspx";
	
	
	String getLoginPwdEncode(String pwd) throws ScriptException, NoSuchMethodException, ClientProtocolException, IOException{
		Result r = SendRequest.sendGet(loginPageUrl, null, null, "utf-8");
		String pageHtml = r.getHttpText();
		
		int tempA = pageHtml.indexOf("new RSAKeyPair(\"")-"var key_to_encode = ".length();
		int tempB = pageHtml.indexOf(");", tempA)+2;
		
		String code = "function getEnKey(pwd){ "+pageHtml.substring(tempA, tempB)+" return encryptedString(key_to_encode, pwd);}";
		
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		if(logger.isDebugEnabled()){
			System.out.println(classPath);
		}
		if(logger.isDebugEnabled()){
			System.out.println(code);
		}
		
//		 //读取JS文件
        BufferedReader buf3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(classPath,"soufang-RSA.js"))));
	         
         //调用js。。这里是关键 啊
         ScriptEngineManager scriptManager = new ScriptEngineManager();
         ScriptEngine jsEngine = scriptManager.getEngineByName("JavaScript");
         //执行JS
//         jsEngine.eval(buf2);
         jsEngine.eval(buf3);
         jsEngine.eval("setMaxDigits(129);  " + code);
         Invocable invocableEngine = (Invocable) jsEngine;
         //p1的获取                                                   执行js中的方法
         String encryptedPwd = (String) invocableEngine.invokeFunction("getEnKey",pwd);
     	if(logger.isDebugEnabled()){
			System.out.println("encryptedPwd:"+encryptedPwd);
		}
     	
     	return encryptedPwd;
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		LoginSoufang loginSoufang = new LoginSoufang();
//		
		String account = "13651817743";
		String password = "13651817743";
		try {
			password = loginSoufang.getLoginPwdEncode(password);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		try {
			String cookie = new LoginSoufang().getLoginCookie(account,password);
			getUserOrderPage(cookie);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void getUserOrderPage(String cookie)
			throws ClientProtocolException, IOException {
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Cookie",cookie);
		Result r = SendRequest.sendGet(user_order, header, null, "utf-8");
		if(logger.isDebugEnabled()){
			System.out.println("debug- userOrder: "+r.getHttpText());
		}
	}


	private String getLoginCookie(String account, String password) throws ClientProtocolException, IOException {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("host", "passport.soufun.com");
		params.put("username", account);
		params.put("service", "soufun");
		params.put("password", password);
		Result r = SendRequest.sendPost(loginDoUrl, null, params, "utf-8");
		if(logger.isDebugEnabled()){
			System.out.println("debug-cookie: "+r.getCookie());
		}
		return r.getCookie();
	}
}
