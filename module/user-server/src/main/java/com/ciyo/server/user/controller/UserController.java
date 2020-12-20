package com.ciyo.server.user.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ciyo.common.exception.BaseException;
import com.ciyo.common.redis.RedisService;
import com.ciyo.common.security.model.CacheUser;
import com.ciyo.common.unitl.R;
import com.ciyo.server.user.model.Role;
import com.ciyo.server.user.model.User;
import com.ciyo.server.user.service.RoleService;
import com.ciyo.server.user.service.UserService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kallen
 * @since 2020-11-29
 */
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private RoleService roleservice;
	@Autowired
	private RedisService redis;
	@GetMapping(value="/login")
	public R<User> login(String key,String passwd,String keytype){
		// TODO Auto-generated method stub
		User user;
		try {
			user = userservice.login(key,passwd,keytype);
	        String uuid = UUID.randomUUID().toString()+"-"+user.getUserId();
	        user.setToken(uuid);
	        CacheUser cacheuser=new CacheUser();
	        cacheuser.setToken(uuid);
	        cacheuser.setUser_id(user.getUserId());
	        cacheuser.setRole(user.getRole());
	        redis.setCacheObject(user.getUserId().toString(),cacheuser);
		} catch (BaseException e) {
			//TODO Auto-generated catch block
			return R.fail(e.getCode(), e.getDefaultMessage());
		}
		//List<String> role=roleservice.getRoleList(user.getUserId());
		//System.out.println(role);
        //密码验证通过
        return R.ok(user);
	}
}