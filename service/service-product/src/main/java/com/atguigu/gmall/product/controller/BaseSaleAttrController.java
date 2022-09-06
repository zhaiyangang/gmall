package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import com.atguigu.gmall.product.service.SkuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售属性API
 * @Auther ZYG
 * @Date 2022/9/2
 */
@Api(tags = "销售属性API",value = "销售属性API")
@RestController
@RequestMapping("/admin/product")
public class BaseSaleAttrController {
    @Autowired
   BaseSaleAttrService baseSaleAttrService;

    /**
     * 获取销售属性
     * @return
     */
    @ApiOperation("获取销售属性")
    @GetMapping("/baseSaleAttrList")
    public Result getbaseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrs = baseSaleAttrService.list();
        return Result.ok(baseSaleAttrs);
    }

}
