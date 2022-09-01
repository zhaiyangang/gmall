package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.common.util.DateUtil;
import com.atguigu.gmall.product.config.minio.MinioAutoConfiguration;
import com.atguigu.gmall.product.config.minio.MinioProperties;
import com.atguigu.gmall.product.service.FileUploadService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther ZYG
 * @Date 2022/8/31
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    MinioAutoConfiguration minioAutoConfiguration;
    @Autowired
    MinioProperties minioProperties;
    /**
     * 文件上传
     * @param file
     * @return
     */
    @Override
    public String upload(MultipartFile file) throws Exception {
        MinioClient minioClient = minioAutoConfiguration.minioClient();
        // 3,使用putObject上传一个文件到存储桶中
        String dateUrl = DateUtil.formatDate(new Date());
        String originalFilename = UUID.randomUUID().toString().replace("-","")
                +"_"+file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        String contentType = file.getContentType();
        PutObjectOptions options = new PutObjectOptions(file.getSize(), -1L);
        options.setContentType(contentType);
        //4,文件上传
        minioClient.putObject(minioProperties.getBucketName(),
                dateUrl+"/"+originalFilename,
                inputStream,
                options);
        //5,返回url
        String url = minioProperties.getEndpoint()+"/"+minioProperties.getBucketName()+"/"+dateUrl+"/"+originalFilename;
        return url;
    }
}
