package com.ayguigu.gmall.item.service.impl;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.ayguigu.gmall.item.feign.SkuDetailFeignClient;
import com.ayguigu.gmall.item.service.SkuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther ZYG
 * @Date 2022/9/10
 */
@Service
public class SkuDetailServiceImpl implements SkuDetailService {
    @Autowired
    SkuDetailFeignClient skuDetailFeignClient;
    /**
     * 查询商品详情页所需数据
     * @param skuId 前端所带商品id
     * @return SkuDetailTo
     */
    @Override
    public SkuDetailTo getSkuDetail(Long skuId) {
        SkuDetailTo skuDetailTo = new SkuDetailTo();
        //TODO 准备查询所需要的数据
        Result<SkuDetailTo> skuDetai = skuDetailFeignClient.getSkuDetai(skuId);
        SkuDetailTo data = skuDetai.getData();
        return data;
    }
}
