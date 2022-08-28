package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_attr_value(属性值表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class BaseAttrValueServiceImpl extends ServiceImpl<BaseAttrValueMapper, BaseAttrValue>
    implements BaseAttrValueService{
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    /**
     * 根据平台属性id查询所有的平台属性值
     * @param attrId
     * @return
     */
    @Override
    public List<BaseAttrValue> getAttrValueList(Long attrId) {
        QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper(attrId);
        wrapper.eq("attr_id",attrId);
        List<BaseAttrValue> valueList = baseAttrValueMapper.selectList(wrapper);
        return valueList;
    }
}




