package com.ciyo.server.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.springframework.context.annotation.Bean;
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = { "com.ciyo.*" })
@MapperScan(basePackages = { "com.ciyo.server.user.mapper" })
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class);
	}
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1.定义fastJson转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
}