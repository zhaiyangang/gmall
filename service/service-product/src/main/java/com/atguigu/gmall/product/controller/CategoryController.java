package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import com.atguigu.gmall.product.service.BaseCategory3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther ZYG
 * @Date 2022/8/24
 */
@RequestMapping("/admin/product")
@RestController
public class CategoryController {
//    /admin/product/getCategory1

    @Autowired
    BaseCategory1Service baseCategory1Service;

    @Autowired
    BaseCategory2Service baseCategory2Service;

    @Autowired
    BaseCategory3Service baseCategory3Service;

    /**
     * 获取一级分类
     * @return
     */
    @GetMapping("/getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> list = baseCategory1Service.list();
        return Result.ok(list);
    }
    ///admin/product/getCategory2/2  查询二级分类

    /**
     * 获取指定一级分类下的所有二级分类
     * @return
     */
    @GetMapping("getCategory2/{c1id}")
    public Result getCategory2(@PathVariable("c1id")Long c1id){
        List<BaseCategory2> Category2=baseCategory2Service.getCategory2(c1id);
        return Result.ok(Category2);
    }

    /**
     * 获取某个二级分类下的所有三级分类
     * @param c2id
     * @return
     */
    @GetMapping("/getCategory3/{c2id}")
    public Result getCategory3(@PathVariable("c2id")Long c2id){
        List<BaseCategory3> Category3=baseCategory3Service.getCategory3(c2id);
        return Result.ok(Category3);
    }
}
