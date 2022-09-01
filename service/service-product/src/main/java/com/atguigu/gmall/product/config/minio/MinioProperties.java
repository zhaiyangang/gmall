package com.atguigu.gmall.product.config.minio;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther ZYG
 * @Date 2022/9/1
 */
@ConfigurationProperties(prefix = "app.minio")
@Component
@Data
public class MinioProperties {
    String endpoint;
    String accessKey;
    String secretKey;
    String bucketName;
}
