package com.huigenghao.basic.service.remote.proxy.api.sp.tc58;

import com.huigenghao.basic.service.remote.proxy.api.sp.ProxyApi;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateUsedEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.CreateUsedEstateResponse58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelUsedEstateRequest58;
import com.huigenghao.basic.service.remote.proxy.api.sp.tc58.model.DelUsedEstateResponse58;

public abstract class AbstractUsedEstateProxyApi58 implements ProxyApi {
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

	public abstract CreateUsedEstateResponse58 create(CreateUsedEstateRequest58 createRequest);
	public abstract DelUsedEstateResponse58 del(DelUsedEstateRequest58 delRequest);
	
	
}
