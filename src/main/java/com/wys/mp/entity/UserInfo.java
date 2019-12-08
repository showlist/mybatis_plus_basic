package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity {

	private static final long serialVersionUID = -2055466952779608007L;

	private String username;

	private String password;

	private String email;

	private String avtar;

	private String phone;

	private String dr;

	@Builder
	private UserInfo(Integer id, Date cdt, Date mdt, String username, String password, String email, String avtar,
			String phone, String dr) {
		super(id, cdt, mdt);
		this.username = username;
		this.password = password;
		this.email = email;
		this.avtar = avtar;
		this.phone = phone;
		this.dr = dr;
	}

}
