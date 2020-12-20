package com.ciyo.geteway.filter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSON;
import com.ciyo.common.constant.CacheConstants;
import com.ciyo.common.redis.RedisService;
import com.ciyo.common.unitl.R;
import com.ciyo.common.unitl.StringUtils;
import reactor.core.publisher.Mono;
@Component
public class TokenFilter implements GlobalFilter, Ordered {
	@Autowired
	private RedisService redis;
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String url = exchange.getRequest().getURI().getPath();
		if(UrlFilter.hasAutorize(url)) {
			return chain.filter(exchange);
		}
		String token=getToken(exchange.getRequest());
        if (StringUtils.isBlank(token))
        {
            return setUnauthorizedResponse(exchange, "令牌不能为空");
        }
		return chain.filter(exchange); //继续向下
	}
    private Mono<Void> setUnauthorizedResponse(ServerWebExchange exchange, String msg)
    {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.OK);
        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            return bufferFactory.wrap(JSON.toJSONBytes(R.fail(msg)));
        }));
    }
    /**
     * 获取请求token
     */
    private String getToken(ServerHttpRequest request)
    {
        String token = request.getHeaders().getFirst(CacheConstants.HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(CacheConstants.TOKEN_PREFIX))
        {
            token = token.replace(CacheConstants.TOKEN_PREFIX, "");
        }
        return token;
    }
}
