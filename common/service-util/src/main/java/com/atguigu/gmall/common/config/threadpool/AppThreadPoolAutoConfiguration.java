package com.atguigu.gmall.common.config.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * 配置线程池
 * @Auther ZYG
 * @Date 2022/9/15
 */
@EnableConfigurationProperties(AppThreadPoolProperties.class)//开启自动化属性绑定配置
@Configuration
public class AppThreadPoolAutoConfiguration {
    @Autowired
    AppThreadPoolProperties appThreadPoolProperties;
    @Value("${spring.application.name}")
    String applicationName;
    @Bean
    public ThreadPoolExecutor coreExecutor(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                appThreadPoolProperties.getCore(),
                appThreadPoolProperties.getMax(),
                appThreadPoolProperties.getKeepAliveTime(),
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(appThreadPoolProperties.getQueueSize()),
                new ThreadFactory() {
                    int i = 0;//记录线程自增id
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(applicationName+"[care-thread"+i++ +"]");
                        return thread;
                    }
                }, new ThreadPoolExecutor.CallerRunsPolicy()
        );
//        int corePoolSize, 核心线程池： CPU核心数 4
//        int maximumPoolSize,  最大线程数：  8
//        long keepAliveTime,  线程存活时间
//        TimeUnit unit,  时间单位
//        BlockingQueue<Runnable> workQueue  阻塞队列，大小合理
//        ThreadFactory threadFactory, 线程工厂 最好自定义
//        RejectedExecutionHandler handler 拒绝策略,生产环境使用CallerRunsPolicy()
        //new LinkedBlockingQueue<>(10) 队列大小根据吞吐量大小标准来定
        return  executor;
    }
}
