package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * spu相关API
 * @Auther ZYG
 * @Date 2022/9/1
 */
@Api(tags = "spu相关API",value = "spu相关API")
@RequestMapping("/admin/product")
@RestController
public class spuController {
    @Autowired
    SpuInfoService spuInfoService;
    //http://api.gmall.com/admin/product/{page}/{limit}?category3Id=61

    /**
     * 分页获取spu属性
     * @param page
     * @param limit
     * @param category3Id
     * @return
     */
    @ApiOperation("分页获取spu属性")
    @GetMapping("/{page}/{limit}")
    public Result getSpuPage(@PathVariable("page")Long page,
                             @PathVariable("limit")Long limit,
            @RequestParam("category3Id")Long category3Id){
        Page<SpuInfo> spuInfoPage = new Page<>(page,limit);
        QueryWrapper<SpuInfo> spuInfoWrapper = new QueryWrapper<>();
        spuInfoWrapper.eq("category3_id",category3Id);
        Page<SpuInfo> infoPage = spuInfoService.page(spuInfoPage, spuInfoWrapper);
        return Result.ok(infoPage);
    }
    //http://api.gmall.com/admin/product/baseSaleAttrList

    /**
     * 获取销售属性
     * @return
     */
    @ApiOperation("获取销售属性")
    @GetMapping("/baseSaleAttrList")
    public Result baseSaleAttrList(){
        return Result.ok();
    }
}
