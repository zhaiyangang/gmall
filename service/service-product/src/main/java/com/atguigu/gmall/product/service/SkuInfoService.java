package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 刚
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2022-08-25 20:03:45
*/
public interface SkuInfoService extends IService<SkuInfo> {
    /**
     * sku属性保存
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 商品下架
     * @param skuId
     */
    void cancelSale(Long skuId);

    /**
     * 商品上架
     * @param skuId
     */
    void onSale(Long skuId);
}
