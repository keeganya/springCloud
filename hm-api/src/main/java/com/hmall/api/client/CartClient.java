package com.hmall.api.client;

import com.hmall.api.fallback.ItemClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(value = "cart-service"/*,configuration = DefautFeignConfig.class  在某个FeignClient中配置，只对当前FeignClient生效 */)
public interface CartClient {

    @GetMapping("/carts")
    void removeByItemIds(@RequestParam("ids") Collection<Long> itemIds);
}
