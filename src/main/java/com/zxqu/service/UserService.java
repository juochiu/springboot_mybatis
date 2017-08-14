package com.zxqu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxqu.model.JsonResult;
import com.zxqu.mybatis.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public JsonResult getById(Map<String, Object> params) throws Exception{
		JsonResult result = new JsonResult();
		Map<String, Object> date = userMapper.getById(params);
		if(date == null || date.size() <=0){
			result.putFailed("没有搜索到");
		}else{
			result.put(date, "100", "单个用户信息");
		}
		return result;
	}
	
	/**
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public JsonResult addUser(Map<String, Object> params) throws Exception{
		JsonResult result = new JsonResult();
		Integer user = userMapper.addUser(params);
		if(user > 0){
			result.putSuccess();
		}else{
			result.putFailed("添加失败...");
		}
		
		return result;
	}
}
