package com.ayguigu.gmall.item.feign;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/inner/rpc/product")
@FeignClient("service-product")
public interface SkuDetailFeignClient {
    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    @GetMapping("/skudetail/{skuId}")
    Result<SkuDetailTo> getSkuDetai(@PathVariable("skuId")Long skuId);
}
