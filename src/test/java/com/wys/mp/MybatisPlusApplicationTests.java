package com.wys.mp;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wys.mp.entity.RoleInfo;
import com.wys.mp.entity.UserInfo;
import com.wys.mp.manager.RoleInfoManager;
import com.wys.mp.manager.UserInfoManager;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	private UserInfoManager userInfoManager;

	@Autowired
	private RoleInfoManager roleInfoManager;

	@Test
	void contextLoads() {
	}

	/**
	 * 测试新增一个用户
	 */
	@Test
	void testInsert() {
		UserInfo userInfo = UserInfo.builder().username("test_user1").password("123456").phone("13687251964")
				.email("wys10162006@163.com").build();
		System.err.println(userInfoManager.insertOne(userInfo));
	}

	@Test
	void testGet() {
		System.err.println(userInfoManager.getByRecord(UserInfo.builder().id(5).build()));
	}

	@Test
	void testInsertRoleInfo() {
		RoleInfo t = roleInfoManager.insertOne(RoleInfo.builder().roleCode("MANAGER").roleName("普通管理员").build());
		System.err.println(t);
	}

	/**
	 * 测试条件查询
	 */
	@Test
	void testListByCriteria() {
		System.err.println(roleInfoManager.listByIds(Arrays.asList(1, 2, 3)));
	}

}
