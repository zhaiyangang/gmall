package com.ayguigu.gmall.item.service;

import com.atguigu.gmall.model.to.SkuDetailTo;

public interface SkuDetailService {
    /**
     * 查询详情页所需的数据
     * @param skuId
     * @return
     */
    SkuDetailTo getSkuDetail(Long skuId);
}
