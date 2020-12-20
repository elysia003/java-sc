package com.ciyo.server.user.service;

import com.ciyo.server.user.model.Role;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
public interface RoleService extends IService<Role> {
	public List<String> getRoleList(@Param("user_id") long user_id);
}
