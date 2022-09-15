package com.atguigu.gmall.common.config.threadpool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther ZYG
 * @Date 2022/9/15
 */

@ConfigurationProperties("app.thread-pool")
@Data
public class AppThreadPoolProperties {
    /**
     * core: 4
     *     max: 8
     *     queue-size: 2000
     *     keep-alive-time: 300 #  秒为单位
     */
    Integer core = 2;
    Integer max = 4;
    Integer queueSize =200;
    Long keepAliveTime = 300l;
}
