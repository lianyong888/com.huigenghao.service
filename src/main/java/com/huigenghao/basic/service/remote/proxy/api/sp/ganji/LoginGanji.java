package com.huigenghao.basic.service.remote.proxy.api.sp.ganji;

import java.io.IOException;
import java.util.HashMap;

import javax.script.ScriptException;

import org.apache.http.client.ClientProtocolException;

import com.huigenghao.tool.http.httpclient.NetServiceException;
import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

/**
 * 赶集登录
 * @author loowj@loowj.com
 */
public class LoginGanji {
	String loginDoUrl = "http://www.ganji.com/user/login.php";
	String encoding = "utf-8";
	String jsPath = "C:/58.js";
	
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
//		Result loginResult = SendRequest.sendGet("https://passport.ganji.com/login.php", null, null, encoding);
//	 	String cookie = loginResult.getCookie();
	 	
		//组装参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("login_username", account);
		params.put("login_password", pwd);
		HashMap<String, String> header = new HashMap<String, String>();
//		header.put("Cookie",cookie);
		//发送请求并获取cookie
		Result r2 = SendRequest.sendPost(loginDoUrl, header, params, encoding);
		System.out.println(r2.getHttpText());
		return r2.getCookie();
	}
	
	public static void main(String[] args) throws Exception {
		String cookie = new LoginGanji().login("loowj@qq.com", "jia8ren7");
		System.out.println(cookie);
//		HashMap<String, String> header2 = new HashMap<String, String>();
//		header2.put("Cookie", cookie);
//		System.out.println(EntityUtils.toString( SendRequest.sendGet("http://www.ganji.com/vip/index.php", header2, null, "utf-8").getHttpEntity(),"utf-8"));
    }
}	
