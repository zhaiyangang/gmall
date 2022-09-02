package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.product.SpuSaleAttrValue;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【spu_info(商品表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
    implements SpuInfoService{
    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    SpuImageService spuImageService;
    @Autowired
    SpuSaleAttrService spuSaleAttrService;
    @Autowired
    SpuSaleAttrValueService spuSaleAttrValueService;
    /**
     * 添加spu
     * @param spuInfo
     */
    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {
        //1,保存spu基本信息
        spuInfoMapper.insert(spuInfo);
        Long spuInfoId = spuInfo.getId();
        //2,保存图片信息
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage spuImage:spuImageList) {
            spuImage.setSpuId(spuInfoId);
        }
        spuImageService.saveBatch(spuImageList);
        //3,保存销售属性名
        List<SpuSaleAttr> saleAttrs= spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr spuSaleAttr:saleAttrs
             ) {
            spuSaleAttr.setSpuId(spuInfoId);
            List<SpuSaleAttrValue> spuSaleAttrValueList = spuSaleAttr.getSpuSaleAttrValueList();
            for (SpuSaleAttrValue spuav:spuSaleAttrValueList
                 ) {
                spuav.setSpuId(spuInfoId);
                String attrName = spuSaleAttr.getSaleAttrName();
                spuav.setSaleAttrName(attrName);
            }
            spuSaleAttrValueService.saveBatch(spuSaleAttrValueList);
        }
        spuSaleAttrService.saveBatch(saleAttrs);
        //3.1,保存销售属性值


    }
}




