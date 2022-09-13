package com.atguigu.gmall.product.api;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.CategoryTreeTo;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 分类有关的API
 * @Auther ZYG
 * @Date 2022/9/7
 * 远程调用都是内部接口：命名规范：/api/inner/rpc/product/模块名/路径
 */
@Api("三级分类RPC方法")
@RestController
@RequestMapping("/api/inner/rpc/product")
public class CategoryApliController {
    @Autowired
    BaseCategory2Service baseCategory2Service;
    /**
     * 查询所有的分类信息，并封装成树形数据结构
     * @return
     */
    @ApiOperation(("三级分类树形数据结构"))
    @GetMapping("/category/tree")
    public Result getCategoryWithTree(){
        List<CategoryTreeTo> categoryategoryTreeTo = baseCategory2Service.getCategoryWithTree();
        return Result.ok(categoryategoryTreeTo);
    }


}
