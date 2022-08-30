package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌API
 * @Auther ZYG
 * @Date 2022/8/30
 */
@RestController
@RequestMapping("admin/product")
public class BaseTrademarkController {
    @Autowired
    BaseTrademarkService baseTrademarkService;
    ///admin/product/baseTrademark/{page}/{limit}

    /**
     * 获取品牌分页列表
     * @param page 第几页
     * @param limit 每页数量
     * @return
     */
    @GetMapping("/baseTrademark/{page}/{limit}")
    public Result baseTrademark(@PathVariable("page")Long page,
                                @PathVariable("limit")Long limit){
        Page<BaseTrademark> page1 = new Page<>(page,limit);
        Page<BaseTrademark> baseTrademarkPage = baseTrademarkService.page(page1);
        return Result.ok(baseTrademarkPage);
    }
    ///admin/product/baseTrademark/save
    public Result save(){
        return Result.ok();
    }
}
