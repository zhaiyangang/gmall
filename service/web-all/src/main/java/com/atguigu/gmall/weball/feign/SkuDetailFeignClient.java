package com.atguigu.gmall.weball.feign;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/inner/rpc/item")
@FeignClient("service-item")//远程调用的客户端,调用的是service-item
public interface SkuDetailFeignClient {
    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    @GetMapping("/skuDetail/{skuId}")
    public Result<SkuDetailTo> getSkuDetail(@PathVariable("skuId")Long skuId);
}

