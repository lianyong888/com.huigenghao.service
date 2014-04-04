package com.huigenghao.basic.service.remote.proxy.api.sp.tc58;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.huigenghao.tool.http.httpclient.NetServiceException;
import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

public class Login58 {
	String loginDoUrl = "https://passport.58.com/dounionlogin";
	String encoding = "utf-8";
	String jsPath = "E:\\云盘\\KuaiPan\\loadProject\\会更好生活服务平台\\58代发资料\\58.js";
	
	/**
	 * 登录
	 * @param account
	 * @param pwd
	 * @param code
	 * @return
	 * @throws NetServiceException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws NoSuchMethodException 
	 * @throws ScriptException 
	 */
	public String login(String account,String pwd) throws NetServiceException, ClientProtocolException, IOException, ScriptException, NoSuchMethodException{
		Result loginResult = SendRequest.sendGet("https://passport.58.com/login", null, null, encoding);
	 	String loginPageHtml = EntityUtils.toString(loginResult.getHttpEntity());
	 	Document document = Jsoup.parse(loginPageHtml);
	 	String cookie = loginResult.getCookie();
        //读取JS文件
        BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jsPath))));
	         
         //调用js。。这里是关键 啊
         ScriptEngineManager scriptManager = new ScriptEngineManager();
         ScriptEngine js = scriptManager.getEngineByExtension("js");
         //执行JS
         js.eval(buf);
         long date = new Date().getTime();
         String time = String.valueOf(date).substring(5, 11);
         Invocable inv2 = (Invocable) js;
	          
         //p1的获取                                                   执行js中的方法
         String p1 = (String) inv2.invokeFunction("getm32str",pwd,time);
	 
        //p2的获取
        String  m32  = (String) inv2.invokeFunction("hex_md5",pwd);
        m32 = m32.substring(8, 24);
	           
		String result = "";
		for (int i = m32.length() - 1; i >= 0; i--) {
		    result += m32.charAt(i);
		}
				
		String p2 = (String)inv2.invokeFunction("getm16str",result,time);
        String p3p1 = "008baf14121377fc76eaf7794b8a8af17085628c3590df47e6534574efcfd81ef8635fcdc67d141c15f51649a89533df0db839331e30b8f8e4440ebf7ccbcc494f4ba18e9f492534b8aafc1b1057429ac851d3d9eb66e86fce1b04527c7b95a2431b07ea277cde2365876e2733325df04389a9d891c5d36b7bc752140db74cb69f";
        String p3p0 = date+""+inv2.invokeFunction("encodeURIComponent", pwd);
        String p3 = (String)inv2.invokeFunction("encryptString",p3p0,"010001",p3p1);
	             
		//组装参数
		HashMap<String, String> params = new HashMap<String, String>();
		String ptk = document.getElementById("ptk").val();
		String cd= document.getElementById("cd").val();
		String mcresult= "186210991";
		params.put("isweak", "0");
		params.put("path", "http://my.58.com/userdata");
		params.put("p1", p1);
		params.put("p2", p2);
		params.put("p3", p3);
		params.put("timesign", String.valueOf(date));
		params.put("ptk", ptk);
		params.put("cd", cd);
		params.put("username", account);
		params.put("password", "password");
		params.put("mcresult", mcresult);
	             
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Cookie",cookie);
		//发送请求并获取cookie
		Result r2 = SendRequest.sendPost(loginDoUrl, header, params, encoding);
		return r2.getCookie();
	}
	
	public static void main(String[] args) throws Exception {
		String cookie = new Login58().login("loowj@qq.com", "jia8ren7");
		HashMap<String, String> header2 = new HashMap<String, String>();
		header2.put("Cookie", cookie);
		System.out.println(EntityUtils.toString( SendRequest.sendGet("http://my.58.com/index/", header2, null, "utf-8").getHttpEntity(),"utf-8"));
    }
}	
