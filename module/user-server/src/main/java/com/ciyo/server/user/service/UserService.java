package com.ciyo.server.user.service;

import com.ciyo.common.exception.BaseException;
import com.ciyo.server.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
public interface UserService extends IService<User> {

	User login(String key, String password, String keytype) throws BaseException;

}
