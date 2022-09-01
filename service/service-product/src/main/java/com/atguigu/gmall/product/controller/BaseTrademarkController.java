package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 品牌API
 * @Auther ZYG
 * @Date 2022/8/30
 */
@Api(tags = "品牌API",value = "品牌API")
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
    @ApiOperation(value = "获取品牌分页列表")
    @GetMapping("/baseTrademark/{page}/{limit}")
    public Result baseTrademark(@PathVariable("page")Long page,
                                @PathVariable("limit")Long limit){
        Page<BaseTrademark> page1 = new Page<>(page,limit);
        Page<BaseTrademark> baseTrademarkPage = baseTrademarkService.page(page1);
        return Result.ok(baseTrademarkPage);
    }
    /**
     * 添加品牌
     * @param baseTrademark
     * @return
     */
    @ApiOperation("添加品牌")
    @PostMapping("baseTrademark/save")
    public Result saveBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }
    /**
     * 根据Id获取品牌
     * @param id 前端传过来的品牌id
     * @return
     */
    @ApiOperation("根据Id获取品牌")
    @GetMapping("/baseTrademark/get/{id}")
    public Result getByIdBaseTrademark(@PathVariable("id")Long id){
        BaseTrademark byId = baseTrademarkService.getById(id);
        return Result.ok(byId);
    }
    /**
     * 修改品牌
     * @param baseTrademark
     * @return
     */
    @ApiOperation("修改品牌")
    @PutMapping("/baseTrademark/update")
    public Result updateBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }
    /**
     * 根据品牌id删除品牌
     * @param id
     * @return
     */
    @ApiOperation("根据品牌id删除品牌")
    @DeleteMapping("/baseTrademark/remove/{id}")
    public Result removeBaseTrademark(@PathVariable("id")Long id){
        baseTrademarkService.removeById(id);
        return Result.ok();
    }
}
