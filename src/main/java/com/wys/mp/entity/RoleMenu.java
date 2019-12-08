package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleMenu extends BaseEntity {

	private static final long serialVersionUID = -4573560460130620595L;

	private Integer roleId;

	private Integer menuId;

	@Builder
	private RoleMenu(Integer id, Date cdt, Date mdt, Integer roleId, Integer menuId) {
		super(id, cdt, mdt);
		this.roleId = roleId;
		this.menuId = menuId;
	}

}
