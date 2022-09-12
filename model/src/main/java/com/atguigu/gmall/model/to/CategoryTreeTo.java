package com.atguigu.gmall.model.to;

import lombok.Data;

import java.util.List;

/**
 * @Auther ZYG
 * @Date 2022/9/7
 * 三级分类树形数据结构
 */
@Data
public class CategoryTreeTo {
    private Long categoryId;
    private String categoryName;
    private List<CategoryTreeTo> categoryChild; //categoryChild

}
