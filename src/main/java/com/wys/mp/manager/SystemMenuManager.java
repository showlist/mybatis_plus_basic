package com.wys.mp.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wys.mp.entity.SystemMenu;
import com.wys.mp.mapper.SystemMenuMapper;

@Service
public class SystemMenuManager extends BaseManager<SystemMenu> {
	
	@Autowired
	private SystemMenuMapper systemMenuMapper;
	
	public List<SystemMenu> listBySystemIds(List<Integer> systemIds){
		return systemMenuMapper.selectList(Wrappers.<SystemMenu>query().in("system_id", systemIds));
	}

}
