package com.wys.mp.manager;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wys.mp.entity.BaseEntity;

public abstract class BaseManager<T extends BaseEntity> {

	@Autowired
	private BaseMapper<T> baseMapper;
	
	public List<T> listByIds(List<Integer> ids){
		return baseMapper.selectList(Wrappers.<T>query().in("id", ids));
	} 
	
	public List<T> listByRecord(T t){
		return baseMapper.selectList(Wrappers.query(t));
	}

	public T getByRecord(T t) {
		return baseMapper.selectOne(Wrappers.query(t));
	}
	
	public T getById(Integer id) {
		return baseMapper.selectById(id);
	}
	
	public int updateByRecord(T t, T record) {
		t.setMdt(Calendar.getInstance().getTime());
		return baseMapper.update(t, Wrappers.update(record));
	}
	
	public T insertOne(T t) {
		t.setCdt(Calendar.getInstance().getTime());
		baseMapper.insert(t);
		return t;
	}
	
	public int updateById(T t) {
		t.setMdt(Calendar.getInstance().getTime());
		return baseMapper.updateById(t);
	}
	
	public int deleteById(Integer id) {
		return baseMapper.deleteById(id);
	}
	
	public int deleteByRecord(T t) {
		return baseMapper.delete(Wrappers.query(t));
	}
	
	public int countByRecord(T t) {
		return baseMapper.selectCount(Wrappers.query(t));
	}

}
