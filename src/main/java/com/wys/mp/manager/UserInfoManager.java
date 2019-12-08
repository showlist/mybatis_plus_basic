package com.wys.mp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wys.mp.entity.UserInfo;
import com.wys.mp.entity.enums.DrEnum;

@Service
public class UserInfoManager extends BaseManager<UserInfo> {
	
	@Autowired
	private PasswordEncoder myPasswordEncoder;

	@Override
	public UserInfo insertOne(UserInfo t) {
		t.setDr(DrEnum.VALID.getCode());
		t.setPassword(myPasswordEncoder.encode(t.getPassword()));
		return super.insertOne(t);
	}

}
