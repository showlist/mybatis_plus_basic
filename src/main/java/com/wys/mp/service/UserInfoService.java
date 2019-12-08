package com.wys.mp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wys.mp.entity.ResourceMenu;
import com.wys.mp.entity.ResourceSystem;
import com.wys.mp.entity.RoleInfo;
import com.wys.mp.entity.RoleMenu;
import com.wys.mp.entity.RoleSystem;
import com.wys.mp.entity.UserInfo;
import com.wys.mp.entity.UserRole;
import com.wys.mp.manager.ResourceMenuManager;
import com.wys.mp.manager.ResourceSystemManager;
import com.wys.mp.manager.RoleInfoManager;
import com.wys.mp.manager.RoleMenuManager;
import com.wys.mp.manager.RoleSystemManager;
import com.wys.mp.manager.UserInfoManager;
import com.wys.mp.manager.UserRoleManger;
import com.wys.mp.security.MyGrantedAuthority;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private UserInfoManager userInfoManager;

	@Autowired
	private UserRoleManger userRoleManger;

	@Autowired
	private RoleInfoManager roleInfoManager;

	@Autowired
	private RoleSystemManager roleSystemManage;

	@Autowired
	private ResourceSystemManager resourceSystemManager;

	@Autowired
	private ResourceMenuManager resourceMenuManager;

	@Autowired
	private RoleMenuManager roleMenuManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("用户名不能为空....................");
		}
		UserInfo userInfo = userInfoManager.getByRecord(UserInfo.builder().username(username).build());
		if (userInfo == null) {
			throw new UsernameNotFoundException("用户名或者密码错误....................");
		}
		List<Integer> roleIds = userRoleManger.listByRecord(UserRole.builder().userId(userInfo.getId()).build())
				.stream().map(x -> x.getRoleId()).collect(Collectors.toList());
		List<RoleInfo> roleInfos = roleInfoManager.listByIds(roleIds);
		List<MyGrantedAuthority> myGrantedAuthorities = roleInfos.stream().map(r -> {
			List<Integer> systemIds = roleSystemManage.listByRecord(RoleSystem.builder().roleId(r.getId()).build())
					.stream().map(rs -> rs.getSystemId()).collect(Collectors.toList());
			List<ResourceSystem> resourceSystems = resourceSystemManager.listByIds(systemIds);
			List<Integer> menuIds = roleMenuManager.listByRecord(RoleMenu.builder().roleId(r.getId()).build()).stream()
					.map(rm -> rm.getMenuId()).collect(Collectors.toList());
			List<ResourceMenu> resourceMenus = resourceMenuManager.listByIds(menuIds);
			return new MyGrantedAuthority(r.getRoleCode(), userInfo, resourceSystems, resourceMenus);
		}).collect(Collectors.toList());

		return new User(username, userInfo.getPassword(), myGrantedAuthorities);
	}

}
