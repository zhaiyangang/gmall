package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.product.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传API
 * @Auther ZYG
 * @Date 2022/8/30
 * 各种注解接不通位置的请求数据
 * @RequestParam: 无论是什么请求 接请求参数； 用一个Pojo把所有数据都接了
 * @RequestPart： 接请求参数里面的文件项
 * @RequestBody： 接请求体中的所有数据 (json转为pojo)
 * @PathVariable: 接路径上的动态变量
 * @RequestHeader: 获取浏览器发送的请求的请求头中的某些值
 * @CookieValue： 获取浏览器发送的请求的Cookie值
 * - 如果多个就写数据，否则就写单个对象
 */
@RequestMapping("/admin/product")
@RestController
public class FileuploadController {
    @Autowired
    FileUploadService fileUploadService;
    /**
     * 文件上传
     * @param file
     * @return
     * @RequestParam("file")MultipartFile file
     * @RequestPart("file")MultipartFile file 专门用来接文件，推荐使用
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestPart("file")MultipartFile file) throws Exception {
        String url = fileUploadService.upload(file);
        return Result.ok(url);
    }
}
