package com.zxqu.mybatis.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	/**
	 * @param params
	 * @return
	 */
	public Map<String,Object> getById(Map<String, Object> params);
	
	public Integer addUser(Map<String, Object> params);
}
