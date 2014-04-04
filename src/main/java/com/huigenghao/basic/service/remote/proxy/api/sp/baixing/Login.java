package com.huigenghao.basic.service.remote.proxy.api.sp.baixing;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;

/**
 * 百姓登录
 * @author loowj@loowj.com
 */
public class Login {
	private static String account = "13651817743";
	private static String password = "#@!789";
	private static String userIndex = "http://www.baixing.com/w/posts";//信息发布
	
	private static String fabu_zz = "http://www.baixing.com/fabu/zhengzu";//整租房
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//发送请求并获取cookie
		Result r = SendRequest.sendGet("http://shanghai.baixing.com/oz/login", null, null, "utf-8");
		
		
		//组装参数
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("identity", account);
		params.put("password", password);
		String loginPageHtml = r.getHttpText();
		Document document = Jsoup.parse(loginPageHtml);
		String token = document.select("input[name=token]").eq(0).val();
		params.put("token", token);
		
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Cookie", r.getCookie());
		String cookie1 =  r.getCookie();
		
		//发送请求并获取cookie
		Result r2 = SendRequest.sendPost("http://shanghai.baixing.com/oz/login", header, params, "utf-8");
//		System.out.println(r2.getHttpText());
//		System.out.println(r2.getCookie());
		getUserIndex(cookie1,r2);
	}

	private static void getUserIndex(String cookie, Result r2) throws ClientProtocolException,
			IOException {
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Cookie", cookie + ";" + r2.getCookie());
		Result userIndexHtml = SendRequest.sendGet(userIndex, header, null, "utf-8");
		System.out.println(userIndexHtml.getHttpText());
	}
}
