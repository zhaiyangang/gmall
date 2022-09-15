package com.atguigu.gmall.product.api;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.to.CategoryViewTo;
import com.atguigu.gmall.model.to.SkuDetailTo;
import com.atguigu.gmall.product.mapper.BaseCategory3Mapper;
import com.atguigu.gmall.product.service.BaseCategory3Service;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品详情数据库层操作API
 * @Auther ZYG
 * @Date 2022/9/12
 */
@Api("商品详情数据库层操作API")
@RestController
@RequestMapping("/api/inner/rpc/product")
public class SkuDetaiApiController {
    @Autowired
    SkuInfoService skuInfoService;
    @Autowired
    SpuSaleAttrService spuSaleAttrService;
    @Autowired
    BaseCategory3Mapper baseCategory3Mapper;
    @Autowired
    BaseCategory3Service baseCategory3Service;
//    /**
//     * 真正查询数据库商品详情
//     * @param skuId
//     * @return
//     */
//    @ApiOperation("查询商品详情")
//    @GetMapping("/skudetail/{skuId}")
//    public Result<SkuDetailTo> getSkuDetai(@PathVariable("skuId")Long skuId){
//        SkuDetailTo skuDetailTo = skuInfoService.getSkuDetail(skuId);
//        return Result.ok(skuDetailTo);
//    }

    /**
     * 查询sku基本信息
     * @param skuId
     * @return
     */
    @ApiOperation("查询SKU的基本信息")
    @GetMapping("/skudetail/info/{skuId}")
    public Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId){
        SkuInfo skuInfo = skuInfoService.getDetailSkuInfo(skuId);
        return Result.ok(skuInfo);
    }

    /**
     * 查询SKU的图片信息
     * @param skuId
     * @return
     */
    @ApiOperation("查询SKU的图片信息")
    @GetMapping("/skudetail/images/{skuId}")
    public Result<List<SkuImage>> getSkuImages(@PathVariable("skuId") Long skuId){
        List<SkuImage> skuImages = skuInfoService.getDetailSkuImages(skuId);
        return Result.ok(skuImages);
    }

    /**
     * 查询SKU的实时价格
     * @param skuId
     * @return
     */
    @ApiOperation("查询SKU的实时价格")
    @GetMapping("/skudetail/price/{skuId}")
    public Result<BigDecimal> get1010Price(@PathVariable("skuId") Long skuId){
        BigDecimal price = skuInfoService.get1010Price(skuId);
        return Result.ok(price);
    }

    /**
     * 查询SKU对应的SPU的销售属性名和值
     * @param skuId
     * @param spuId
     * @return
     */
    @ApiOperation("查询SKU对应的SPU的销售属性名和值")
    @GetMapping("/skudetail/saleattrvalues/{skuId}/{spuId}")
    public Result<List<SpuSaleAttr>> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId,
                                       @PathVariable("spuId") Long spuId){
        List<SpuSaleAttr> attrList = spuSaleAttrService.getSaleAttrAndValueMarkSku(spuId,skuId);
        return Result.ok(attrList);
    }

    /**
     * 查询SKU组合
     * @param spuId
     * @return
     */
    @ApiOperation("查询SKU组合")
    @GetMapping("/skudetail/valueison/{spuId}")
    public Result<String> getValuesSkuJson(@PathVariable("spuId") Long spuId){
        String valueJson = spuSaleAttrService.getAllSkuSaleAttrValueJson(spuId);
        return Result.ok(valueJson);
    }

    /**
     * 根据三级分类查出精确路径
     * @param category3Id
     * @return
     */
    @ApiOperation("查分类")
    @GetMapping("/skudetail/ctegoryview/{category3Id}")
    public Result<CategoryViewTo> getCategoryView(@PathVariable("category3Id")Long category3Id){
        CategoryViewTo categoryViewTo = baseCategory3Service.getCategoryView(category3Id);
        return Result.ok(categoryViewTo);
    }
}
