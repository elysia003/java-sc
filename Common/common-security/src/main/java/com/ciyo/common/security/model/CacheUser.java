package com.ciyo.common.security.model;

import java.util.List;
import java.util.Set;

public class CacheUser {
	@Override
	public String toString() {
		return "CacheUser [token=" + token + ", user_id=" + user_id + ", access_url=" + access_url + ", role=" + role
				+ ", ip=" + ip + ", status=" + status + "]";
	}
	private String token;
	private long user_id;
	private List<String> access_url;
	private List<String> role;
	private String ip;
	private int status;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public List<String> getAccess_url() {
		return access_url;
	}
	public void setAccess_url(List<String> access_url) {
		this.access_url = access_url;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
