package com.ayguigu.gmall.item.controller;

import com.atguigu.gmall.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther ZYG
 * @Date 2022/9/15
 */
@RestController
public class ThreadPoolController {
    @Autowired
    ThreadPoolExecutor executor;
    @GetMapping("/close/pool")
    public Result closePool(){
        executor.shutdown();
        return Result.ok();
    }
}
