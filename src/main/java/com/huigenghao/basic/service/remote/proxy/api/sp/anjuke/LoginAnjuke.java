package com.huigenghao.basic.service.remote.proxy.api.sp.anjuke;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

/**
 * 安居客登录
 * @author loowj@loowj.com
 *
 */
public class LoginAnjuke {
	static Logger logger = Logger.getLogger(LoginAnjuke.class);
	private static String loginPageUrl = "http://user.anjuke.com/my/login";
	private static String loginDoUrl = "http://member.anjuke.com/login";
	private static String user_order = "http://user.anjuke.com/favorite/all/";
	
	
	public static void main(String[] args) {
		String account = "13651817743";
		String password = "13651817743";
		try {
			String cookie = new LoginAnjuke().getLoginCookie(account,password);
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
		header.put("Cookie", cookie);
		Result r = SendRequest.sendGet(user_order, header, null, "utf-8");
		if(logger.isDebugEnabled()){
			System.out.println(r.getHttpText());
		}
	}


	private String getLoginCookie(String account, String password) throws ClientProtocolException, IOException {
		Result loginPageResult = SendRequest.sendGet(loginPageUrl, null, null, "utf-8");
		String loginPageHtml = loginPageResult.getHttpText();
		Document document = Jsoup.parse(loginPageHtml);
		String url = document.select("input[name=url]").eq(0).val();
		String systemtime = document.select("input[name=systemtime]").eq(0).val();
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("loginpost", "1");
		params.put("formhash", "");
		params.put("sid", "anjuke");
		params.put("url", url);
		params.put("systemtime", systemtime);
		params.put("username", account);
		params.put("password", password);
		params.put("remember", "0");
		params.put("submit", "登录");
		Result r = SendRequest.sendPost(loginDoUrl, null, params, "utf-8");
		if(logger.isDebugEnabled()){
			System.out.println(r.getHttpText());
		}
		return r.getCookie();
	}	
}
