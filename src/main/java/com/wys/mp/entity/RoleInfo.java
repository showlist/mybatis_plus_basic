package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleInfo extends BaseEntity {

	private static final long serialVersionUID = -1628086884894176666L;

	private String roleCode;

	private String roleName;

	private String dr;

	@Builder
	private RoleInfo(Integer id, Date cdt, Date mdt, String roleCode, String roleName, String dr) {
		super(id, cdt, mdt);
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.dr = dr;
	}

}
