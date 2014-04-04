package com.huigenghao.basic.service.remote.proxy.api.sp;

import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyResponse;

/**
 * 代理接口
 * @author loowj@loowj.com
 */
public interface ProxyApi {
	/**
	 * 创建代理
	 * @param createRequest
	 * @return
	 */
	public CreateResponse create(CreateRequest createRequest);
	
	/**
	 * 修改代理
	 * @param modifyRequest
	 * @return
	 */
	public ModifyResponse modify(ModifyRequest modifyRequest);
	
	/**
	 * 删除代理
	 * @param modifyRequest
	 * @return
	 */
	public DelResponse del(DelRequest delRequest);
}
