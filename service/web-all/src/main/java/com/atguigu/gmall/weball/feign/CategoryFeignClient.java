package com.atguigu.gmall.weball.feign;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.to.CategoryTreeTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/api/inner/rpc/product")
@FeignClient("service-product")//远程调用的客户端,调用的是service-product
public interface CategoryFeignClient {
    /**
     * 1,给service-product发送一个get方式的请求，路径是/api/inner/rpc/product//category/tree
     * 2，拿到远程响应的json数据，并转成result对象，并且返回的数据是List<CategoryTreeTo>
     * @return
     */
//    @GetMapping("/api/inner/rpc/product//category/tree")
//    Result<List<CategoryTreeTo>> getCategoryTree();
    @GetMapping("/category/tree")
     Result<List<CategoryTreeTo>> getCategoryWithTree();
}
