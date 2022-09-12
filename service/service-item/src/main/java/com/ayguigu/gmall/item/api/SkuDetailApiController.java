package com.ayguigu.gmall.item.api;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.ayguigu.gmall.item.service.SkuDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther ZYG
 * @Date 2022/9/10
 */
@Api("商品详情页")
@RequestMapping("/api/inner/rpc/item")
@RestController
public class SkuDetailApiController {
    @Autowired
    SkuDetailService skuDetailService;
    /**
     * 查询商品详情
     * @param skuId
     * @return
     */
    @GetMapping("/skuDetail/{skuId}")
    Result<SkuDetailTo> getSkuDetail(@PathVariable("skuId")Long skuId){
        SkuDetailTo skuDetailTo = skuDetailService.getSkuDetail(skuId);

        return Result.ok(skuDetailTo);
    }
}
