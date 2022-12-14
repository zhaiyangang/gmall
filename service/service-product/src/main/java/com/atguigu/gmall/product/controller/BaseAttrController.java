package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**平台属性相关Api
 * @Auther ZYG
 * @Date 2022/8/28
 *
 */
@Api(tags = "平台属性API",value = "平台属性API")
@RestController
@RequestMapping("/admin/product")
public class BaseAttrController {
    @Autowired
    BaseAttrInfoService baseAttrInfoService;
    @Autowired
    BaseAttrValueService baseAttrValueService;
    /**
     * 查询某个分类下的所有平台属性
     * @param category1Id 1级分类
     * @param category2Id 2级分类
     * @param category3Id 3级分类
     * @return
     */
    @ApiOperation("查询某个分类下的所有平台属性")
    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getAttrInfoList(@PathVariable("category1Id")Long category1Id,
                                  @PathVariable("category2Id")Long category2Id,
                                  @PathVariable("category3Id")Long category3Id){
        List<BaseAttrInfo> infos =baseAttrInfoService.getAttrInfoAndValueByCategoryId(category1Id,category2Id,category3Id);


        return Result.ok(infos);
    }
    //saveAttrInfo

    /**
     * 保存、修改二合一平台属性信息
     * @param info
     * @return
     */
    @ApiOperation("保存、修改二合一平台属性信息")
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo info){
        //如果携带的数据中id值为null那么是新增操作，如果不为null那就是修改操作
        baseAttrInfoService.saveAttrInfo(info);
        return Result.ok();
    }
    //根据id查询平台属性/getAttrValueList/11

    /**
     * 根据平台属性id查询所有的平台属性值
     * @param attrId
     * @return
     */
    @ApiOperation("根据平台属性id查询所有的平台属性值")
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId")Long attrId){
        List<BaseAttrValue> valueList = baseAttrValueService.getAttrValueList(attrId);
        return Result.ok(valueList);

    }

}
