package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.to.CategoryTreeTo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import com.atguigu.gmall.product.mapper.BaseCategory2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_category2(二级分类表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class BaseCategory2ServiceImpl extends ServiceImpl<BaseCategory2Mapper, BaseCategory2>
    implements BaseCategory2Service{
    @Autowired
    BaseCategory2Mapper baseCategory2Mapper;

    /**
     * 获取某个一级分类的所有二级分类
     * @param c1id
     * @return
     */
    @Override
    public List<BaseCategory2> getCategory2(Long c1id) {
        //select * from base_category2 where category1_id=1;
        QueryWrapper<BaseCategory2> wrapper=new QueryWrapper();
        wrapper.eq("category1_id",c1id);
        List<BaseCategory2> list=baseCategory2Mapper.selectList(wrapper);
        return list;
    }

    /**
     * 获取所有的分类。并封装成树形数据结构
     * @return
     */
    @Override
    public List<CategoryTreeTo> getCategoryWithTree() {


        return baseCategory2Mapper.getCategoryWithTree();
    }
}




