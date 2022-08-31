package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.product.service.FileUploadService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Auther ZYG
 * @Date 2022/8/31
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    @Override
    public String upload(MultipartFile file) throws Exception {
        //1,先创建出一个MinioClient对象
        MinioClient minioClient = new MinioClient("http://192.168.200.100:9000",
                "admin",
                "admin123456");
        // 2,检查存储桶是否已经存在
        boolean isExist = minioClient.bucketExists("gmall");
        if(isExist) {
        } else {
            // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
            minioClient.makeBucket("asiatrip");
        }
        // 3,使用putObject上传一个文件到存储桶中
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        PutObjectOptions options = new PutObjectOptions(file.getSize(), -1L);
        options.setContentType(contentType);
        //4,文件上传
        minioClient.putObject("gmall",
                originalFilename,
                inputStream,
                options);
        //5,返回url
        String url = "http://192.168.200.100:9000/gmall/"+originalFilename;
        return url;
    }
}
