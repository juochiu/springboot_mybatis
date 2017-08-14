package com.zxqu.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zxqu.model.JsonResult;
import com.zxqu.service.UserService;


@RestController
//@RequestMapping(value = "user")
public class UserController {
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public JsonResult getById(@RequestParam Map<String, Object> params) throws Exception{
		log.info("getById--->");
		JsonResult data = new JsonResult();
		data = userService.getById(params);
		return data;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public JsonResult addUser(@RequestBody Map<String, Object> params) throws Exception{
		log.info("addUser--->");
		JsonResult result = new JsonResult();
		result = userService.addUser(params);
		return result;
	}
}
