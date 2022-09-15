package com.ayguigu.gmall.item.service.impl;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.to.CategoryViewTo;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.ayguigu.gmall.item.feign.SkuDetailFeignClient;
import com.ayguigu.gmall.item.service.SkuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther ZYG
 * @Date 2022/9/10
 */
@Service
public class SkuDetailServiceImpl implements SkuDetailService {
    @Autowired
    SkuDetailFeignClient skuDetailFeignClient;
    @Autowired
    ThreadPoolExecutor executor;

    /**
     * 查询商品详情页所需数据
     * @param skuId 前端所带商品id
     * @return SkuDetailTo
     */
    @Override
    public SkuDetailTo getSkuDetail(Long skuId) {


        SkuDetailTo skuDetailTo = new SkuDetailTo();
//        CompletableFuture.supplyAsync(); 启用异步编排 ，有返回值
//        CompletableFuture.runAsync();  启用异步编排 ，没有返回值

        //准备查询所需要的数据

        //1，查询基本信息
        CompletableFuture<SkuInfo> skuInfoFuutre = CompletableFuture.supplyAsync(() -> {
            Result<SkuInfo> result = skuDetailFeignClient.getSkuInfo(skuId);
            SkuInfo skuInfo = result.getData();
            skuDetailTo.setSkuInfo(skuInfo);
            return skuInfo;
        }, executor);


        //2，查询图片信息
        CompletableFuture<Void> imagesFuture = skuInfoFuutre.thenAcceptAsync(skuInfo -> {
            Result<List<SkuImage>> skuImages = skuDetailFeignClient.getSkuImages(skuId);
            skuInfo.setSkuImageList(skuImages.getData());
        }, executor);

        //3，查询商品的实时价格
        CompletableFuture<Void> priceFuture= CompletableFuture.runAsync(() -> {
            Result<BigDecimal> price = skuDetailFeignClient.get1010Price(skuId);
            skuDetailTo.setPrice(price.getData());
        }, executor);

        //4，查销售属性名和值
        CompletableFuture<Void> attrValuesFuture = skuInfoFuutre.thenAcceptAsync(skuInfo -> {
            Long spuId = skuInfo.getSpuId();
            Result<List<SpuSaleAttr>> attrValues = skuDetailFeignClient.getSkuSaleAttrValues(skuId, spuId);
            skuDetailTo.setSpuSaleAttrList(attrValues.getData());
        },executor);

        //5，查sku组合
        CompletableFuture<Void> valuesSkuJsonFuture = skuInfoFuutre.thenAcceptAsync(skuInfo -> {
            Long spuId = skuInfo.getSpuId();
            Result<String> valuesSkuJson = skuDetailFeignClient.getValuesSkuJson(spuId);
            skuDetailTo.setValuesSkuJson(valuesSkuJson.getData());
        }, executor);

        //6，查分类
        CompletableFuture<Void> categoryViewFuture = skuInfoFuutre.thenAcceptAsync(skuInfo -> {
            Result<CategoryViewTo> categoryView = skuDetailFeignClient.getCategoryView(skuInfo.getCategory3Id());
            skuDetailTo.setCategoryView(categoryView.getData());
        },executor);


        CompletableFuture.allOf(imagesFuture,priceFuture,attrValuesFuture,valuesSkuJsonFuture,categoryViewFuture)
                .join();
        return skuDetailTo;
    }
}
