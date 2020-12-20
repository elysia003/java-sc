package com.ciyo.server.user.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    private Long userId;

    private String role;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
        "userId=" + userId +
        ", role=" + role +
        "}";
    }
}
