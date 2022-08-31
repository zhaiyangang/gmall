package com.atguigu.gmall.product.service;

import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    String upload(MultipartFile file) throws Exception;
}
