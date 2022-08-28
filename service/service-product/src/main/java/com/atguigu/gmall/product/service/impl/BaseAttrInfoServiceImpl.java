package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
    implements BaseAttrInfoService{
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    /**
     * 查询某个分类下的所有平台属性
     * @param category1Id 1级分类
     * @param category2Id 2级分类
     * @param category3Id 3级分类
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrInfoAndValueByCategoryId(Long category1Id, Long category2Id, Long category3Id) {
        //自定义SQL查询
        List<BaseAttrInfo> infos = baseAttrInfoMapper.getAttrInfoAndValueByCategoryId(category1Id,category2Id,category3Id);
        return infos;
    }

    /**
     * 保存平台属性信息
     * @param info
     */
    @Override
    public void saveAttrInfo(BaseAttrInfo info) {
    //1、保存属性名
        baseAttrInfoMapper.insert(info);
        Long id = info.getId();
        //2、保存属性值
        List<BaseAttrValue> list = info.getAttrValueList();
        for (BaseAttrValue value:list
             ) {
            //回填属性名的自增id
            value.setAttrId(id);
            baseAttrValueMapper.insert(value);
        }

    }
}




