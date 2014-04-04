package com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model;

/**
 * 整套出租
 * @author loowj@loowj.com
 */
public class CreateRentEstateWholeReuqest58 extends CreateRentEstateRequest58 {
	private String HireType = "2";

	public String getHireType() {
		return HireType;
	}

	public void setHireType(String hireType) {
		HireType = hireType;
	}
}
