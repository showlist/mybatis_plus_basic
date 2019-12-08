package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleSystem extends BaseEntity {

	private static final long serialVersionUID = -4564169344742765044L;

	private Integer roleId;

	private Integer systemId;

	@Builder
	private RoleSystem(Integer id, Date cdt, Date mdt, Integer roleId, Integer systemId) {
		super(id, cdt, mdt);
		this.roleId = roleId;
		this.systemId = systemId;
	}

}