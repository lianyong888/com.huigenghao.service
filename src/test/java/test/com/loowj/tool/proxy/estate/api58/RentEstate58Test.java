package test.com.loowj.tool.proxy.estate.api58;

import org.junit.Test;

import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.RentEstate58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateResponse58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateWholeReuqest58;

public class RentEstate58Test {
	RentEstate58 rentEstate58 = new RentEstate58();
	
	private CreateRentEstateWholeReuqest58 getZhenZuBean() {
		CreateRentEstateWholeReuqest58 createRequest = new CreateRentEstateWholeReuqest58();
		createRequest.setContent("真的好房出租啦，再不租就亏死了");
		createRequest.setFitType("5");	/**装修情况 1毛胚,2简单装修,3中的装修,4精装修,5豪华装修, */
		createRequest.setFloor("6");/**楼层 所在楼层 数字 必须*/
		createRequest.setFukuanfangshi("0");/** 租房方式 0面议,1押一付三,押一付二,3押一付一,4押二付二,5押二付三,6半年付,7年付 必须 */
		createRequest.setGoblianxiren("罗伟俊");/** 联系人姓名  必须 */
		createRequest.setHireType("1");/**出租方式 单间=0,床位=1,整套=2 必须*/
		createRequest.setHouseAllocation("4,5,6,7,8,9,10");	/**房屋配置 6床,15衣柜,14沙发,4电视,冰箱5,洗衣机6,空调7,热水器8,宽带9,暖气10,*/
		createRequest.setJushishuru("3");
		createRequest.setHuxingshi("3");	/**居室 数字 必须*/
		createRequest.setHuxingting("2");/**户型厅 数字 必须*/
		createRequest.setHuxingwei("1");/**户型卫 数字 必须*/
		createRequest.setArea("130");
		createRequest.setIsBiz("0");//个人=0,经纪人=1
		createRequest.setMinPrice("2000");/** 租金 必须 */
		createRequest.setObjectType("3");/**房屋类型 3普通住宅,7商住两用,4公寓,2平房,5别墅,6其它 */
		createRequest.setPhone("13651817743");/** 联系电话  必须 */
		createRequest.setTitle("天天好房出租，不住可惜了");
		createRequest.setToward("1");/**朝向 1东,2南,3西,4北,南北5,东西6,东南7,西南8,东北9,西北10 */
		createRequest.setXiaoqu("新开家园");//小区名称
		createRequest.setZonglouceng("20");/**楼层 共多少层 数字 必须*/
		return createRequest;
	}
	
	/**
	 * 整租房
	 */
	@Test
	public final void testCreateCreateRentEstateRequest58() {
		CreateRentEstateWholeReuqest58 createRequest = getZhenZuBean();
		CreateRentEstateResponse58 createRentEstateResponse58 = (CreateRentEstateResponse58)rentEstate58.create(createRequest);
		System.out.println(createRentEstateResponse58.getMsg());
	}

}
