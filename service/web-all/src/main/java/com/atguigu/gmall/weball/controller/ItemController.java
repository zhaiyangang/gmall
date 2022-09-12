package com.atguigu.gmall.weball.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.atguigu.gmall.weball.feign.SkuDetailFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 处理商品详情
 * @Auther ZYG
 * @Date 2022/9/9
 */
@Controller
public class ItemController {
    @Autowired
    SkuDetailFeignClient skuDetailFeignClient;
    /**
     * 跳转到商品详情页
     * @param skuId
     * @return
     */
    @GetMapping("/{skuId}.html")
    public String item(@PathVariable("skuId")Long skuId , Model model){
//        SkuDetailTo skuDetailTo = skuFeignClient.getSkuDetail(skuId);
        //远程查出商品详情
        Result<SkuDetailTo> result = skuDetailFeignClient.getSkuDetail(skuId);
        if (result.isOk()){
            SkuDetailTo skuDetailTo = result.getData();
            model.addAttribute("categoryView",skuDetailTo.getCategoryView());
            model.addAttribute("skuInfo",skuDetailTo.getSkuInfo());
            model.addAttribute("price",skuDetailTo.getPrice());//商品的价格
            model.addAttribute("spuSaleAttrList",skuDetailTo.getSpuSaleAttrList());//spu的销售属性列表
            model.addAttribute("valuesSkuJson",skuDetailTo.getValuesSkuJson());//json
        }

        return "item/index";
    }
}
