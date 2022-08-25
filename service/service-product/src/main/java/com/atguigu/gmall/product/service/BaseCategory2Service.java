package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_category2(二级分类表)】的数据库操作Service
* @createDate 2022-08-25 20:03:45
*/
public interface BaseCategory2Service extends IService<BaseCategory2> {

    /**
     * 获取某个一级分类的所有二级分类
     * @param c1id
     * @return
     */
    List<BaseCategory2> getCategory2(Long c1id);
}
