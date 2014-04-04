package com.huigenghao.basic.service.remote.proxy.api.sp.ganji;

import com.huigenghao.basic.service.remote.proxy.api.sp.ProxyApi;
import com.huigenghao.basic.service.remote.proxy.api.sp.ganji.model.CreateUsedEstateRequestGJ;
import com.huigenghao.basic.service.remote.proxy.api.sp.ganji.model.CreateUsedEstateResponseGJ;
import com.huigenghao.basic.service.remote.proxy.api.sp.ganji.model.DelUsedEstateRequestGJ;
import com.huigenghao.basic.service.remote.proxy.api.sp.ganji.model.DelUsedEstateResponseGJ;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.CreateResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.DelResponse;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyRequest;
import com.huigenghao.basic.service.remote.proxy.api.sp.model.ModifyResponse;

public abstract class AbstractUsedEstateProxyApiGJ implements ProxyApi {
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

	public abstract CreateUsedEstateResponseGJ create(CreateUsedEstateRequestGJ createRequest);
	public abstract DelUsedEstateResponseGJ del(DelUsedEstateRequestGJ delRequest);
	
	
}
