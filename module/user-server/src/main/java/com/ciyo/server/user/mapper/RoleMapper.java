package com.ciyo.server.user.mapper;

import com.ciyo.server.user.model.Role;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
public interface RoleMapper extends BaseMapper<Role> {
	@Select("select role from role where user_id=#{user_id}")
	public List<String> getRoleList(@Param("user_id") long user_id);
}
