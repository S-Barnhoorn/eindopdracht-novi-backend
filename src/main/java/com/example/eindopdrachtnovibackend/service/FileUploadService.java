package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.FileUpload;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

public interface FileUploadService {

    Iterable<FileUpload> getFiles();
    FileUpload getFileById(long id);
    boolean fileExistsById(long id);
    long uploadFile(MultipartFile file);
    void deleteFile(long id);
    Resource downloadFile(long id);


}