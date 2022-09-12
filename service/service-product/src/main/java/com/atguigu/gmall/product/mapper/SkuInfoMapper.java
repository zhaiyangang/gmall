package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
* @author 刚
* @description 针对表【sku_info(库存单元表)】的数据库操作Mapper
* @createDate 2022-08-25 20:03:45
* @Entity com.atguigu.gmall.product.domain.SkuInfo
*/
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {
    /**
     * 商品上、下架
     * @param skuId
     * @param sale
     */
    void updateIsSale(@Param("skuId") Long skuId, @Param("sale") int sale);

    /**
     * 查询某个商品的实时价格
     * @param skuId
     * @return
     */
    BigDecimal getRealPrice(@Param("skuId") Long skuId);
}




