package com.wys.mp.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wys.mp.entity.RoleSystem;
import com.wys.mp.mapper.RoleSystemMapper;

@Service
public class RoleSystemManager extends BaseManager<RoleSystem> {

	@Autowired
	private RoleSystemMapper roleSystemMapper;

	public List<RoleSystem> listByRoleIds(List<Integer> roleIds) {
		return roleSystemMapper.selectList(Wrappers.<RoleSystem>query().in("role_id", roleIds));
	}

}
