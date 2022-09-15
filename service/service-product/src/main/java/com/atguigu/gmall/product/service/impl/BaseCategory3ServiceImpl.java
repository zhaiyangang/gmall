package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.model.to.CategoryViewTo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseCategory3Service;
import com.atguigu.gmall.product.mapper.BaseCategory3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_category3(三级分类表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class BaseCategory3ServiceImpl extends ServiceImpl<BaseCategory3Mapper, BaseCategory3>
    implements BaseCategory3Service{
    @Autowired
    BaseCategory3Mapper baseCategory3Mapper;
    /**
     * 获取某个二级分类下的所有三级分类
     * @param c2id
     * @return
     */
    @Override
    public List<BaseCategory3> getCategory3(Long c2id) {
        QueryWrapper<BaseCategory3> wrapper=new QueryWrapper<>();
        wrapper.eq("category2_id",c2id);
        List<BaseCategory3> baseCategory3s = baseCategory3Mapper.selectList(wrapper);
        return baseCategory3s;
    }

    /**
     * 根据三级分类查出精确路径
     * @param category3Id
     * @return
     */
    @Override
    public CategoryViewTo getCategoryView(Long category3Id) {
        CategoryViewTo categoryViewTo = baseCategory3Mapper.getCategoryView(category3Id);
        return categoryViewTo;
    }
}




