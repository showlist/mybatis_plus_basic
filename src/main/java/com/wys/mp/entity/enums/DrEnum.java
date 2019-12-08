package com.wys.mp.entity.enums;

public enum DrEnum {

	VALID("1", "可用的"), INVALID("0", "不可用");

	private String code;

	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private DrEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
