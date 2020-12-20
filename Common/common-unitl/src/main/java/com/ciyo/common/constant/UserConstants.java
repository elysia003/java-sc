package com.ciyo.common.constant;

/**
 * 用户常量信息
 * 
 * @author ruoyi
 */
public class UserConstants
{
    /**
     * 平台内系统用户的唯一标志
     */
    public static final String SYS_USER = "SYS_USER";

    /** 正常状态 */
    public static final String NORMAL = "0";
    /** 异常状态 */
    public static final String EXCEPTION = "1";
    /** 用户封禁状态 */
    public static final String USER_DISABLE = "2";
    /** 角色封禁状态 */
    public static final String ROLE_DISABLE = "1";
    /** 校验返回结果码 */
    public final static String UNIQUE = "0";

    public final static String NOT_UNIQUE = "1";

    /**
     * 用户名长度限制
     */
    public static final int USERNAME_MIN_LENGTH = 2;

    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * 密码长度限制
     */
    public static final int PASSWORD_MIN_LENGTH = 5;

    public static final int PASSWORD_MAX_LENGTH = 20;
}
