package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * 保存、修改二合一平台属性信息
     * @param info
     */
    @Override
    public void saveAttrInfo(BaseAttrInfo info) {
        //如果携带的数据中id值为null那么是新增操作，如果不为null那就是修改操作
        if (info.getId()==null) {
            insert(info);
        }else {
            updateBaseAttrInfo(info);
        }

    }

    /**
     * 修改平台属性值
     * @param info
     */
    private void updateBaseAttrInfo(BaseAttrInfo info) {
        //修改属性信息
        //删除前端没有带来的属性信息
        List<BaseAttrValue> valueList = info.getAttrValueList();
        List<Long> vids = new ArrayList<>();
        for (BaseAttrValue attrValue:valueList) {
            Long id = attrValue.getId();
            if (id != null){
                vids.add(id);
            }
        }
        //delete * from base_attr_value where attr_id=11 and id not in(vids)
        if(vids.size()>0){
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id", info.getId());
            deleteWrapper.notIn("id",vids);
            baseAttrValueMapper.delete(deleteWrapper);
        }else {
            //全部删除
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id", info.getId());
            baseAttrValueMapper.delete(deleteWrapper);
        }

        //1、修改属性名信息
        baseAttrInfoMapper.updateById(info);
        //2、修改属性值信息

        for (BaseAttrValue attrValue:valueList) {
            if (attrValue.getId()!=null){
                //修改
                baseAttrValueMapper.updateById(attrValue);
            }else if (attrValue.getId()==null){
                //新增
                attrValue.setAttrId(info.getId());
                baseAttrValueMapper.insert(attrValue);
            }
        }
    }

    /**
     * 保存平台属性方法
     * @param info
     */
    private void insert(BaseAttrInfo info) {
        //1、保存属性名
        baseAttrInfoMapper.insert(info);
        Long id = info.getId();
        //2、保存属性值
        List<BaseAttrValue> list = info.getAttrValueList();
        for (BaseAttrValue value : list
        ) {
            //回填属性名的自增id
            value.setAttrId(id);
            baseAttrValueMapper.insert(value);
        }
    }
}




