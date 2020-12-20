package com.ciyo.common.unitl;

import java.time.LocalDateTime;

public class RUser {
	private String username;
	private String nickname;
	private String avatar;
	private String last_ip;
	private LocalDateTime last_time;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	public LocalDateTime getLast_time() {
		return last_time;
	}
	public void setLast_time(LocalDateTime last_time) {
		this.last_time = last_time;
	}
	
}
