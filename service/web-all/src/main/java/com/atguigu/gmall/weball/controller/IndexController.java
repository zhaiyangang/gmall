package com.atguigu.gmall.weball.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.CategoryTreeTo;
import com.atguigu.gmall.weball.feign.CategoryFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 页面跳转
 * @Auther ZYG
 * @Date 2022/9/7
 */
@Controller
public class IndexController {
    @Autowired
    CategoryFeignClient categoryFeignClient;
    /**
     * 跳转首页
     * @param model
     * @return
     */
    @GetMapping({"/","/index"})
    public String indexPage(Model model){
        // 查询数据，封装成树形数据
        // id aa bb cc dd
        // id x y z d
        Result<List<CategoryTreeTo>> result = categoryFeignClient.getCategoryWithTree();
        if (result.isOk()) {
            //远程成功
            List<CategoryTreeTo> data = result.getData();
            model.addAttribute("list",data);
        }
        return "index/index";//逻辑视图
    }
}
