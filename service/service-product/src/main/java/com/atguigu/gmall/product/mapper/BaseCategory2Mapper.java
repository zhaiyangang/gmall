package com.atguigu.gmall.product.mapper;


import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.to.CategoryTreeTo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_category2(二级分类表)】的数据库操作Mapper
* @createDate 2022-08-25 20:03:45
* @Entity com.atguigu.gmall.product.domain.BaseCategory2
*/
public interface BaseCategory2Mapper extends BaseMapper<BaseCategory2> {
    /**
     * 查询所有分类以及子分类
     * @return
     */
    List<CategoryTreeTo> getCategoryWithTree();

}




