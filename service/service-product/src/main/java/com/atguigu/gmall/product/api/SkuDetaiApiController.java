package com.atguigu.gmall.product.api;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.atguigu.gmall.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品详情数据库层操作API
 * @Auther ZYG
 * @Date 2022/9/12
 */
@Api("商品详情数据库层操作API")
@RestController
@RequestMapping("/api/inner/rpc/product")
public class SkuDetaiApiController {
    @Autowired
    SkuInfoService skuInfoService;
    /**
     * 真正查询数据库商品详情
     * @param skuId
     * @return
     */
    @ApiOperation("查询商品详情")
    @GetMapping("/skudetail/{skuId}")
    public Result<SkuDetailTo> getSkuDetai(@PathVariable("skuId")Long skuId){
        SkuDetailTo skuDetailTo = skuInfoService.getSkuDetail(skuId);
        return Result.ok(skuDetailTo);
    }
    /**
     * 数据库层真正查询商品详情
     * @param skuId
     * @return
     */
//    @GetMapping("/skudetail/{skuId}")
//    public Result<SkuDetailTo> getSkuDetail(@PathVariable("skuId") Long skuId){
//        //准备查询所有需要的数据
//        SkuDetailTo skuDetailTo = skuInfoService.getSkuDetail(skuId);
//        return Result.ok(skuDetailTo);
//    }
}
