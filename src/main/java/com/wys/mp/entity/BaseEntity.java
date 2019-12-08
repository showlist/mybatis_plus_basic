package com.wys.mp.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -8897850034085135709L;

	@TableId(type = IdType.AUTO)
	private Integer id;

	private Date cdt;

	private Date mdt;

}
