package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传API
 * @Auther ZYG
 * @Date 2022/8/30
 */
@RequestMapping("/admin/product")
@RestController
public class FileuploadController {
    /**
     * 文件上传
     * @param file
     * @return
     * @RequestParam("file")MultipartFile file
     * @RequestPart("file")MultipartFile file 专门用来接文件，推荐使用
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestPart("file")MultipartFile file){
        return Result.ok();
    }
}
