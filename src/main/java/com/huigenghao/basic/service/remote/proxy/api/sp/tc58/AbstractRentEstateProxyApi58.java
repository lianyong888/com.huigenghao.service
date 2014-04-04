package com.huigenghao.basic.service.remote.proxy.api.sp.tc58;

import com.huigenghao.basic.service.remote.proxy.api.sp.ProxyApi;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateRentEstateResponse58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelRentEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelRentEstateResponse58;

public abstract class AbstractRentEstateProxyApi58 implements ProxyApi {
	@Override
	public CreateResponse create(CreateRequest createRequest) {
		return create(createRequest);
	}
	
	@Override
	public DelResponse del(DelRequest delRequest) {
		return del(delRequest);
	}
	
	@Override
	public ModifyResponse modify(ModifyRequest modifyRequest) {
		return null;
	}

	public abstract CreateRentEstateResponse58 create(CreateRentEstateRequest58 createRequest);
	public abstract DelRentEstateResponse58 del(DelRentEstateRequest58 delRequest);
	
	
}
