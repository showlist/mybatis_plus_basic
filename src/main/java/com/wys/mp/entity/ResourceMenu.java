package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ResourceMenu extends BaseEntity {

	private static final long serialVersionUID = 7761494192479088188L;

	private String menuName;

	private String menuCode;

	private String menuUrl;

	private String dr;

	@Builder
	private ResourceMenu(Integer id, Date cdt, Date mdt, String menuName, String menuCode, String menuUrl, String dr) {
		super(id, cdt, mdt);
		this.menuName = menuName;
		this.menuCode = menuCode;
		this.menuUrl = menuUrl;
		this.dr = dr;
	}

}
