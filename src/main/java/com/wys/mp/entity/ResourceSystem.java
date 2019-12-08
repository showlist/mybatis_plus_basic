package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResourceSystem extends BaseEntity {

	private static final long serialVersionUID = -5876124572363535773L;

	private String systemCode;

	private String systeName;

	private String systemUrl;

	private String dr;

	@Builder
	private ResourceSystem(Integer id, Date cdt, Date mdt, String systemCode, String systeName, String systemUrl,
			String dr) {
		super(id, cdt, mdt);
		this.systemCode = systemCode;
		this.systeName = systeName;
		this.systemUrl = systemUrl;
		this.dr = dr;
	}

}
