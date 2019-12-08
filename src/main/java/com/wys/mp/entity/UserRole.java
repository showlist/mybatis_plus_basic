package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity {

	private static final long serialVersionUID = 6600351998093516761L;

	private Integer userId;

	private Integer roleId;

	@Builder
	private UserRole(Integer id, Date cdt, Date mdt, Integer userId, Integer roleId) {
		super(id, cdt, mdt);
		this.userId = userId;
		this.roleId = roleId;
	}

}
