package com.huigenghao.basic.service.remote.proxy.api.sp.model;

/**
 * 代理创建接口结果
 * @author loowj@loowj.com
 */
public class CreateResponse {
	String code;
	String msg;
	boolean success;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
