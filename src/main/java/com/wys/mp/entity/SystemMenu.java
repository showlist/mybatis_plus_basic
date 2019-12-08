package com.wys.mp.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SystemMenu extends BaseEntity {

	private static final long serialVersionUID = 6317309158412993378L;

	private Integer systemId;

	private Integer menuId;

	@Builder
	private SystemMenu(Integer id, Date cdt, Date mdt, Integer systemId, Integer menuId) {
		super(id, cdt, mdt);
		this.systemId = systemId;
		this.menuId = menuId;
	}

}
