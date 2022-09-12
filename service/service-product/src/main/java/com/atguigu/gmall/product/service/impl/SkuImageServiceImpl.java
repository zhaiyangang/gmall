package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.SkuImage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.SkuImageService;
import com.atguigu.gmall.product.mapper.SkuImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刚
* @description 针对表【sku_image(库存单元图片表)】的数据库操作Service实现
* @createDate 2022-08-25 20:03:45
*/
@Service
public class SkuImageServiceImpl extends ServiceImpl<SkuImageMapper, SkuImage>
    implements SkuImageService{
    @Autowired
    SkuImageMapper skuImageMapper;
    /**
     * 根据SKUID查询对应的图片信息
     * @param skuId
     * @return
     */
    @Override
    public List<SkuImage> getSkuImage(Long skuId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("sku_id",skuId);

        return skuImageMapper.selectList(wrapper);
    }
}




