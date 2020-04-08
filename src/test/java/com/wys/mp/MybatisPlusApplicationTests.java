package com.wys.mp;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
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
		AutoGenerator autoGenerator = new AutoGenerator();
		// 全局配置
		GlobalConfig globalConfig = new GlobalConfig()
					.setOutputDir("F:/Users/Administrator/java_projects/mybatis-plus/demo/src/main/java")
					.setAuthor("wys")
					.setFileOverride(true)
					.setOpen(true)
					.setBaseResultMap(true)
					.setBaseColumnList(true)
					.setDateType(DateType.TIME_PACK)
					.setEntityName("%s")
					.setServiceName("%sManager")
					.setMapperName("%sMapper")
					.setXmlName("%sMapper.xml")
					.setIdType(IdType.AUTO);
		// 数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig()
						.setUrl("jdbc:mysql://192.168.0.106:3306/mybatis_plus?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false")
						.setDriverName("com.mysql.cj.jdbc.Driver")
						.setUsername("root")
						.setPassword("wys123456")
						.setDbType(DbType.MYSQL);
		// 数据表配置
		StrategyConfig stcStrategyConfig = new StrategyConfig()
						.setSkipView(false)
						.setNaming(NamingStrategy.underline_to_camel)
						.setColumnNaming(NamingStrategy.underline_to_camel)
						.setSuperEntityColumns("id","cdt","mdt")
						.setSuperEntityClass("com.wys.mp.entity.BaseEntity")
						.setSuperServiceClass("com.wys.mp.manager.BaseManager")
						.setInclude("resource_menu","resource_system","role_info","role_menu","role_system","system_menu","user_info","user_role")
						.setEntityBuilderModel(true)
						.setEntityLombokModel(true)
						;
		// 包配置
		PackageConfig packageConfig = new PackageConfig()
				.setParent("com.wys.mp")
				.setEntity("entity")
				.setService("manager")
				.setMapper("mapper")
				.setXml("mapper");
		// 模板配置
		TemplateConfig templateConfig = new TemplateConfig();
		
		autoGenerator.setDataSource(dataSourceConfig).setGlobalConfig(globalConfig).setPackageInfo(packageConfig)
					 .setStrategy(stcStrategyConfig).setTemplate(templateConfig).execute();
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
