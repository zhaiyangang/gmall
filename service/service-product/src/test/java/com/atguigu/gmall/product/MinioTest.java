package com.atguigu.gmall.product;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther ZYG
 * @Date 2022/8/31
 */
//@SpringBootTest//可以测试Springboot的所有组件
public class MinioTest {
    @Test
    public void testMinio() throws Exception{
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://192.168.200.100:9000",
                                                        "admin",
                                                        "admin123456");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("gmall");
            if(isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("asiatrip");
            }

            // 使用putObject上传一个文件到存储桶中。
            //String bucketName,桶名
            // String objectName,文件名‪C:\Users\刚\Desktop\桌面2\壁纸\壁纸2号.png
            // InputStream stream,文件流
            // PutObjectOptions options, 上传的参数设置
            FileInputStream inputStream = new FileInputStream("C:\\Users\\刚\\Desktop\\桌面2\\壁纸\\壁纸2号.png");
            PutObjectOptions options = new PutObjectOptions(inputStream.available(), -1);
            options.setContentType("image/png");
            minioClient.putObject("gmall",
                    "壁纸2号.png",
                    inputStream,
                    options);
            System.out.println("上传成功");
        } catch(MinioException e) {
            System.err.println("上传失败： " + e);
        }
    }

}
