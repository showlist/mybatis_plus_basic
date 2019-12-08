package com.wys.mp.manager;

import org.springframework.stereotype.Service;

import com.wys.mp.entity.RoleInfo;
import com.wys.mp.entity.enums.DrEnum;

@Service
public class RoleInfoManager extends BaseManager<RoleInfo>{
	
	
	@Override
	public RoleInfo insertOne(RoleInfo t) {
		t.setDr(DrEnum.VALID.getCode());
		return super.insertOne(t);
	}

}
