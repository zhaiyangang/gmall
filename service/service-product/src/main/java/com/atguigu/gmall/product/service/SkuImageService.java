package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 刚
* @description 针对表【sku_image(库存单元图片表)】的数据库操作Service
* @createDate 2022-08-25 20:03:45
*/
public interface SkuImageService extends IService<SkuImage> {
    /**
     * 根据SKUID查询对应的图片信息
     * @param skuId
     * @return
     */
    List<SkuImage> getSkuImage(Long skuId);
}
