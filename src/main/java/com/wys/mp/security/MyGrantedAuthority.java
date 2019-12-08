package com.wys.mp.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.wys.mp.entity.ResourceMenu;
import com.wys.mp.entity.ResourceSystem;
import com.wys.mp.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = -1226073999556910223L;

	private String roleString;

	private UserInfo userInfo;

	private List<ResourceSystem> resourceSystems;

	private List<ResourceMenu> resourceMenus;

	@Override
	public String getAuthority() {
		return roleString;
	}

}
