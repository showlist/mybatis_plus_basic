package com.wys.mp.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wys.mp.entity.RoleMenu;
import com.wys.mp.mapper.RoleMenuMapper;

@Service
public class RoleMenuManager extends BaseManager<RoleMenu> {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	public List<RoleMenu> listByRoleIds(List<Integer> roleIds) {
		return roleMenuMapper.selectList(Wrappers.<RoleMenu>query().in("role_id", roleIds));
	}

}
