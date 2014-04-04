package com.huigenghao.basic.service.remote.proxy.api.sp.tc58;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

import org.apache.http.client.ClientProtocolException;

import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateResponse58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelRentEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelRentEstateResponse58;
import com.huigenghao.tool.http.httpclient.NetServiceException;
import com.huigenghao.tool.http.httpclient.Result;
import com.huigenghao.tool.http.httpclient.SendRequest;
import com.loowj.core.util.lang.ObjectUtil;

/**
 * 58 租房
 * @author loowj@loowj.com
 */
public class RentEstate58 extends AbstractRentEstateProxyApi58{
	private String url = "http://post.58.com/1086/8/s5";
	private String encoding = "utf-8";
	
	@Override
	public CreateRentEstateResponse58 create(CreateRentEstateRequest58 createRequest) {
		CreateRentEstateResponse58 response = new CreateRentEstateResponse58();
		try {
			String cookie = new Login58().login("loowj@qq.com", "jia8ren7");
			HashMap<String, String> header = new HashMap<String, String>();
			header.put("Cookie", cookie);
			Map<String, String> params = ObjectUtil.convertBean(createRequest);
			Result r2 = SendRequest.sendPost(url+"/submit", header, params, encoding);
			response.setMsg(r2.getHttpText());
		} catch (NetServiceException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public DelRentEstateResponse58 del(DelRentEstateRequest58 delRequest) {
		return null;
	}
}
