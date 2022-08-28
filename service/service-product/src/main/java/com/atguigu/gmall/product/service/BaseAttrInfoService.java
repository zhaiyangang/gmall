package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 刚
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2022-08-25 20:03:45
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    /**
     * 查询某个分类下的所有平台属性
     * @param category1Id 1级分类
     * @param category2Id 2级分类
     * @param category3Id 3级分类
     * @return
     */
    List<BaseAttrInfo> getAttrInfoAndValueByCategoryId(Long category1Id, Long category2Id, Long category3Id);

    /**
     * 保存平台属性信息
     * @param info
     */
    void saveAttrInfo(BaseAttrInfo info);
}
