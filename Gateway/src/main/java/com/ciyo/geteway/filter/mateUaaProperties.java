package com.ciyo.geteway.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@RefreshScope
@ConfigurationProperties(prefix = "mate.uaa")
public class mateUaaProperties {

	/**
	 * 忽略URL，List列表形式
	 */
	
	private List<String> ignoreUrl = new ArrayList<>();

	public static String[] getEndpoints() {
		return ENDPOINTS;
	}

	public void setIgnoreUrl(List<String> ignoreUrl) {
		this.ignoreUrl = ignoreUrl;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * 是否启用网关鉴权模式
	 */
	private Boolean enable = false;

	/**
	 * 监控中心和swagger需要访问的url
	 */
	private static final String[] ENDPOINTS = {
			"/oauth/**",
			"/actuator/**",
			"/v2/api-docs/**",
			"/v2/api-docs-ext/**",
			"/swagger/api-docs",
			"/swagger-ui.html",
			"/doc.html",
			"/swagger-resources/**",
			"/webjars/**",
			"/druid/**",
			"/error/**",
			"/assets/**",
			"/auth/logout",
			"/auth/code"
	};

	/**
	 * 自定义getter方法，并将ENDPOINTS加入至忽略URL列表
	 * @return List
	 */
	public List<String> getIgnoreUrl() {
		if (!ignoreUrl.contains("/doc.html")) {
			Collections.addAll(ignoreUrl, ENDPOINTS);
		}
		return ignoreUrl;
	}

	public Boolean getEnable() {
		return enable;
	}
}
