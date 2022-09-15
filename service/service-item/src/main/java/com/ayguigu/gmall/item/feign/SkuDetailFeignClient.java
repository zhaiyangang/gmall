package com.ayguigu.gmall.item.feign;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuImage;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.model.to.CategoryViewTo;
import com.atguigu.gmall.model.to.SkuDetailTo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/api/inner/rpc/product")
@FeignClient("service-product")
public interface SkuDetailFeignClient {
//    /**
//     * 查询商品详情
//     * @param skuId
//     * @return
//     */
//    @GetMapping("/skudetail/{skuId}")
//    Result<SkuDetailTo> getSkuDetai(@PathVariable("skuId")Long skuId);
    /**
     * 查询sku基本信息
     * @param skuId
     * @return
     */
    @GetMapping("/skudetail/info/{skuId}")
    Result<SkuInfo> getSkuInfo(@PathVariable("skuId") Long skuId);

    /**
     * 查询SKU的图片信息
     * @param skuId
     * @return
     */
    @GetMapping("/skudetail/images/{skuId}")
    Result<List<SkuImage>> getSkuImages(@PathVariable("skuId") Long skuId);

    /**
     * 查询SKU的实时价格
     * @param skuId
     * @return
     */
    @GetMapping("/skudetail/price/{skuId}")
    Result<BigDecimal> get1010Price(@PathVariable("skuId") Long skuId);

    /**
     * 查询SKU对应的SPU的销售属性名和值
     * @param skuId
     * @param spuId
     * @return
     */
    @GetMapping("/skudetail/saleattrvalues/{skuId}/{spuId}")
    Result<List<SpuSaleAttr>> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId,
                                                          @PathVariable("spuId") Long spuId);

    /**
     * 查询SKU组合
     * @param spuId
     * @return
     */
    @GetMapping("/skudetail/valueison/{spuId}")
    Result<String> getValuesSkuJson(@PathVariable("spuId") Long spuId);

    /**
     * 根据三级分类查出精确路径
     * @param category3Id
     * @return
     */
    @GetMapping("/skudetail/ctegoryview/{category3Id}")
    Result<CategoryViewTo> getCategoryView(@PathVariable("category3Id")Long category3Id);
}
