package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * sku相关API
 * @Auther ZYG
 * @Date 2022/9/2
 */
@Api(tags = "sku相关API",value = "sku相关API")
@RestController
@RequestMapping("/admin/product")
public class skuContrller {
    @Autowired
    SkuInfoService skuInfoService;
    @Autowired
    SkuImageService skuImageService;
    @Autowired
    SpuImageService spuImageService;
    @Autowired
    SpuSaleAttrService spuSaleAttrService;
    /**
     * 获取sku分页列表
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation("获取sku分页列表")
    @GetMapping("/list/{page}/{limit}")
    public Result spuPageList(@PathVariable("page")Long page,
                               @PathVariable("limit")Long limit){
        Page<SkuInfo> page1 = new Page<>(page,limit);
        Page<SkuInfo> result = skuInfoService.page(page1);
        return Result.ok(result);
    }
    /**
     * 根据spuId获取图片列表
     * @param spuId
     * @return
     */
    @ApiOperation("根据spuId获取图片列表")
    @GetMapping("/spuImageList/{spuId}")
    public Result spuImageList(@PathVariable("spuId")Long spuId){
        QueryWrapper<SpuImage> spuImageQueryWrapper = new QueryWrapper<>();
        spuImageQueryWrapper.eq("spu_id",spuId);
        List<SpuImage> spuImages = spuImageService.list(spuImageQueryWrapper); //调错mservice了！！
        return Result.ok(spuImages);
    }


    /**
     * 根据spuId获取销售属性
     * @param spuId
     * @return
     */
    @ApiOperation("根据spuId获取销售属性")
    @GetMapping("/spuSaleAttrList/{spuId}")
    public Result getSpuSaleAttr(@PathVariable("spuId")Long spuId){
        List<SpuSaleAttr> spuSaleAttrs = spuSaleAttrService.getSpuSaleAttrAndValueByspuId(spuId);

        return Result.ok(spuSaleAttrs);
    }
}
