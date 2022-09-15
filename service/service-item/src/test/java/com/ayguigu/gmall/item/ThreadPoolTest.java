package com.ayguigu.gmall.item;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther ZYG
 * @Date 2022/9/15
 */
@SpringBootTest
public class ThreadPoolTest {
    @Autowired
    ThreadPoolExecutor executor;
    @Test
    void testPool(){
        for(int i=0;i<100;i++){


        executor.submit(()->{

            System.out.println(Thread.currentThread().getName()+":哈哈哈哈，你真帅,我好喜欢"+ UUID.randomUUID().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
