package com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model;

import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateRequest;

/**
 * 创建58租房请求
 * @author loowj@loowj.com
 */
public class CreateRentEstateRequest58 extends CreateRequest{
	/**出租方式 单间=0,床位=1,整套=2 必须*/
	public String HireType;
	/**身份 个人=0,经纪人=1  必须*/
	public String isBiz;
	/**小区 必须*/
	public String xiaoqu;
	/**大学*/
	public String daxue;
	/**线路周边*/
	public String xianluzhoubian;
	/**地铁线*/
	public String ditiexian;
	public String stationdistance;
	public String ditiezhan;
	public String gongjiaoxian;
	public String busdistance;
	public String gongjiaozhan;
	public String distancetime;
	public String refpricexiaoquid;
	public String localArea;
	public String localDiduan;
	public String dizhi;
	/**居室 数字 必须*/
	public String jushishuru;
	public String huxingshi;
	/**户型厅 数字 必须*/
	public String huxingting;
	/**户型卫 数字 必须*/
	public String huxingwei;
	/**面积 数字 必须*/
	public String area;
	/**楼层 所在楼层 数字 必须*/
	public String Floor;
	/**楼层 共多少层 数字 必须*/
	public String zonglouceng;
	/**朝向 1东,2南,3西,4北,南北5,东西6,东南7,西南8,东北9,西北10 */
	public String Toward;
	/**装修情况 1毛胚,2简单装修,3中的装修,4精装修,5豪华装修, */
	public String FitType;
	/**房屋类型 3普通住宅,7商住两用,4公寓,2平房,5别墅,6其它 */
	public String ObjectType;
	/**房屋配置 6床,15衣柜,14沙发,4电视,冰箱5,洗衣机6,空调7,热水器8,宽带9,暖气10,*/
	public String HouseAllocation;
	/** 租金 必须 */
	public String MinPrice;
	/** 租房方式 0面议,1押一付三,押一付二,3押一付一,4押二付二,5押二付三,6半年付,7年付 必须 */
	public String fukuanfangshi = "0";
	/** 标题  string 必须*/
	public String Title;
	public String titleeditflag;
	
	/** 房源描述  string 必须*/
	public String Content;
	public String pic;
	public String pictag;
	public String picdesc1;

	public String editorValue;
	
	/**验证码*/
	public String codeText;
	
	
	/** 联系人姓名  必须 */
	public String goblianxiren;
	/** 联系电话  必须 */
	public String Phone;
	
	public String getHireType() {
		return HireType;
	}
	public void setHireType(String hireType) {
		HireType = hireType;
	}
	public String getIsBiz() {
		return isBiz;
	}
	public void setIsBiz(String isBiz) {
		this.isBiz = isBiz;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	public String getJushishuru() {
		return jushishuru;
	}
	public void setJushishuru(String jushishuru) {
		this.jushishuru = jushishuru;
	}
	public String getHuxingshi() {
		return huxingshi;
	}
	public void setHuxingshi(String huxingshi) {
		this.huxingshi = huxingshi;
	}
	public String getHuxingting() {
		return huxingting;
	}
	public void setHuxingting(String huxingting) {
		this.huxingting = huxingting;
	}
	public String getHuxingwei() {
		return huxingwei;
	}
	public void setHuxingwei(String huxingwei) {
		this.huxingwei = huxingwei;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return Floor;
	}
	public void setFloor(String floor) {
		Floor = floor;
	}
	public String getZonglouceng() {
		return zonglouceng;
	}
	public void setZonglouceng(String zonglouceng) {
		this.zonglouceng = zonglouceng;
	}
	public String getToward() {
		return Toward;
	}
	public void setToward(String toward) {
		Toward = toward;
	}
	public String getFitType() {
		return FitType;
	}
	public void setFitType(String fitType) {
		FitType = fitType;
	}
	public String getObjectType() {
		return ObjectType;
	}
	public void setObjectType(String objectType) {
		ObjectType = objectType;
	}
	public String getHouseAllocation() {
		return HouseAllocation;
	}
	public void setHouseAllocation(String houseAllocation) {
		HouseAllocation = houseAllocation;
	}
	public String getMinPrice() {
		return MinPrice;
	}
	public void setMinPrice(String minPrice) {
		MinPrice = minPrice;
	}
	public String getFukuanfangshi() {
		return fukuanfangshi;
	}
	public void setFukuanfangshi(String fukuanfangshi) {
		this.fukuanfangshi = fukuanfangshi;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getGoblianxiren() {
		return goblianxiren;
	}
	public void setGoblianxiren(String goblianxiren) {
		this.goblianxiren = goblianxiren;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
}
