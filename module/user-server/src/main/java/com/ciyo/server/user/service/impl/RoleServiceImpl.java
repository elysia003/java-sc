package com.ciyo.server.user.service.impl;

import com.ciyo.server.user.model.Role;
import com.ciyo.server.user.mapper.RoleMapper;
import com.ciyo.server.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
	public List<String> getRoleList(@Param("user_id") long user_id) {
		return baseMapper.getRoleList(user_id);
	}
}
