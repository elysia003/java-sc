package com.ciyo.server.user.service.impl;
import com.ciyo.server.user.model.User;
import com.ciyo.common.constant.UserConstants;
import com.ciyo.common.exception.BaseException;
import com.ciyo.common.redis.RedisService;
import com.ciyo.common.security.model.CacheUser;
import com.ciyo.server.user.mapper.RoleMapper;
import com.ciyo.server.user.mapper.UserMapper;
import com.ciyo.server.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kallen
 * @since 2020-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Autowired
	private UserMapper userdao;
	@Autowired
	private RoleMapper roledao;
	@Override
	public User login(String key, String password,String keytype) throws BaseException{
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(keytype,key);
        User user=(User)userdao.selectOne(queryWrapper);
        if(user==null) {
        	throw new BaseException("user",1001,"用户不存在");
        }
        else if(!password.equals(user.getPasswd())) {
        	throw new BaseException("user",1002,"帐号密码错误");
        }
        else if(!UserConstants.NORMAL.equals(user.getStatus())) {
        	throw new BaseException("user",1003,"用户状态异常");
        }
        List<String> role=roledao.getRoleList(user.getUserId());
        user.setRole(role);
        return user;
    }
}