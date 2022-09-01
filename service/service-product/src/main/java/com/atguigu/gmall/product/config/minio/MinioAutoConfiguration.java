package com.atguigu.gmall.product.config.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther ZYG
 * @Date 2022/9/1
 */
@Configuration
public class MinioAutoConfiguration {
    @Autowired
    MinioProperties minioProperties;
    /**
     * 创建minioClient对象
     * @return
     */
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(),
                minioProperties.getAccessKey(),
                minioProperties.getSecretKey());
        // 2,检查存储桶是否已经存在
        String bucketName = minioProperties.getBucketName();
        boolean isExist = minioClient.bucketExists(bucketName);
        if(isExist) {
        } else {
            // 创建一个名为bucketName的存储桶，用于存储照片的zip文件。
            minioClient.makeBucket(bucketName);
        }
        return minioClient;
    }
}
