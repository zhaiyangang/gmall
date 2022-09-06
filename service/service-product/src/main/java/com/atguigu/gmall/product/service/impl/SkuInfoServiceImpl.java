package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SkuAttrValue;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SkuSaleAttrValue;
import com.atguigu.gmall.product.service.SkuAttrValueService;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.service.SkuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.mapper.SkuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 刚
* @description 针对表【sku_info(库存单元表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo>
    implements SkuInfoService{
    @Autowired
    SkuInfoMapper skuInfoMapper;
    @Autowired
    SkuImageService skuImageService;
    @Autowired
    SkuAttrValueService skuAttrValueService;
    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;
    /**
     * SKU属性保存
     * @param skuInfo
     */
    @Transactional//添加事务管理
    @Override
    public void saveSkuInfo(SkuInfo skuInfo) {
        //1,sku基本信息保存到 sku——info
        save(skuInfo);
        Long infoId = skuInfo.getId();

        //2,sku的图片信息保存懂啊 sku_image
        for (SkuImage image:skuInfo.getSkuImageList()
             ) {
            image.setSkuId(infoId);
        }
        skuImageService.saveBatch(skuInfo.getSkuImageList());

        //3,sku的平台属性名和值的关系保存到sku_attr_value
        skuInfo.getSkuAttrValueList();
        for (SkuAttrValue attrValue:skuInfo.getSkuAttrValueList()
             ) {
            attrValue.setSkuId(infoId);
        }
        skuAttrValueService.saveBatch(skuInfo.getSkuAttrValueList());

        //4,sku的销售属性名和值的关系保存到 sku_sale_attr_value
        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        for (SkuSaleAttrValue saleAttrValue:skuSaleAttrValueList
             ) {
            saleAttrValue.setSkuId(infoId);
            saleAttrValue.setSpuId(skuInfo.getSpuId());
        }
        skuSaleAttrValueService.saveBatch(skuSaleAttrValueList);

    }

    /**
     * 商品下架
     * @param skuId
     */
    @Override
    public void cancelSale(Long skuId) {
        //1，更改数据库sku_info 中的is_sale: 1上架 0 下架
        skuInfoMapper.updateIsSale(skuId,0);
    }

    /**
     * 商品上架
     * @param skuId
     */
    @Override
    public void onSale(Long skuId) {
        skuInfoMapper.updateIsSale(skuId,1);
    }
}




