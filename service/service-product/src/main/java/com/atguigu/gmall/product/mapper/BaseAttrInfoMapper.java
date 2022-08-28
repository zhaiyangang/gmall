package com.atguigu.gmall.product.mapper;


import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_attr_info(属性表)】的数据库操作Mapper
* @createDate 2022-08-25 20:03:45
* @Entity com.atguigu.gmall.product.domain.BaseAttrInfo
*/
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {
    /**
     * 查询某个分类下的平台属性的自定义SQL
     * @param category1Id 1级分类id
     * @param category2Id 2级分类id
     * @param category3Id 3级分类id
     * @return
     */
    List<BaseAttrInfo> getAttrInfoAndValueByCategoryId(@Param("category1Id")Long category1Id,
                                                       @Param("category2Id")Long category2Id,
                                                       @Param("category3Id")Long category3Id);
}




