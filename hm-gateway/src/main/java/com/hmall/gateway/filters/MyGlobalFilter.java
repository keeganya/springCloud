package com.hmall.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author xiaohu
 * @Date 2024/12/3 10:36
 * @PackageName:com.hmall.gateway.filters
 * @ClassName: MyGlobalFilter
 * @Description: ServerWebExchange exchange: 请求上下文，保存的是request,response,session等整个过滤器链内中共享的数据
 *               GatewayFilterChain chain: 过滤器链，当前过滤器执行完后，要调用过滤器链中的下一个过滤器
 * @Version 1.0
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 模拟登录校验逻辑
        HttpHeaders headers = exchange.getRequest().getHeaders();
        System.out.println("Heads =" + headers);
        /**
         * chain.filter是在调用过滤器链中的下一过滤器，
         * chain.filter(exchange) 传入 exchange 会把 exchange 传给下一过滤器
         * */
        // 放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        /**
        * 过滤器执行顺序 值越小 优先级越高
        * */
        return 0;
    }
}
