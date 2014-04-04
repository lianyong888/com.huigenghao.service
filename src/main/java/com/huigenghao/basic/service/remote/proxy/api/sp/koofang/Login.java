package com.huigenghao.basic.service.remote.proxy.api.sp.koofang;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

/**
 * 酷房登录
 * @author loowj@loowj.com
 *
 */
public class Login {
	static Logger logger = Logger.getLogger(Login.class);
	private static String loginDoUrl = "http://shanghai.koofang.com/login/register.php?action=login";
	private static String user_order = "http://shanghai.koofang.com/space?showdiv=0";
	
	
	public static void main(String[] args) {
		String account = "13651817743";
		String password = "#@!789";
		try {
			String cookie = new Login().getLoginCookie(account,password);
			if(logger.isDebugEnabled()){
				System.out.println(cookie);
			}
			
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
			System.out.println(r.getHttpText());
		}
	}


	private String getLoginCookie(String account, String password) throws ClientProtocolException, IOException {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("username", account);
		params.put("passwd", password);
		Result r = SendRequest.sendPost(loginDoUrl, null, params, "utf-8");
		if(logger.isDebugEnabled()){
			System.out.println(r.getHttpText());
		}
		return r.getCookie();
	}
	
	
}
