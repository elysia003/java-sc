package com.ciyo.server.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>
 * 
 * </p>
 *
 * @author kallen
 * @since 2020-11-30
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "user_id", type = IdType.AUTO)
	@JSONField(serialize = false)
	private Integer userId;

	@JSONField(serialize = false)
	private String username;

	@JSONField(serialize = false)
	private String passwd;

	private String nickname;

	@JSONField(serialize = false)
	private String email;

	@JSONField(serialize = false)
	private String phone;

	private String avatar;
	@JSONField(serialize = false)
	private String status;

	private String lastIp;

	private LocalDateTime lastTime;

	@JSONField(serialize = false)
	private LocalDateTime createTime;

	@JSONField(serialize = false)
	private LocalDateTime updateTime;

	@TableField(exist = false)
	@JSONField(serialize = false)
	private List<String> role;

	@TableField(exist = false)
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public User(String username, String passwd, String nickname, String email, String phone, String avatar) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.avatar = avatar;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public LocalDateTime getLastTime() {
		return lastTime;
	}

	public void setLastTime(LocalDateTime lastTime) {
		this.lastTime = lastTime;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", passwd=" + passwd + ", nickname=" + nickname
				+ ", email=" + email + ", phone=" + phone + ", avatar=" + avatar + ", status=" + status + ", lastIp="
				+ lastIp + ", lastTime=" + lastTime + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", role=" + role + "]";
	}

}
