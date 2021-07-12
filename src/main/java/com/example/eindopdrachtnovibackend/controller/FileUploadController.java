package com.example.eindopdrachtnovibackend.controller;

import com.example.eindopdrachtnovibackend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/files")
    public ResponseEntity<Object> getFilesInfo() {
        return ResponseEntity.ok(fileUploadService.getFiles());
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable("id") long id) {
        fileUploadService.getFileById(id);
        return ResponseEntity.ok(fileUploadService.getFileById(id));
    }

//    @GetMapping("/files/id")
//    public ResponseEntity<Object> getFileData(@PathVariable long id) {
//        return ResponseEntity.ok(fileUploadService.getFileById(id));
//    }

//    @GetMapping("/files/{id}/download")
//    public ResponseEntity downloadFile(@PathVariable long id) {
//
//        Resource resource = FileUploadService.downloadFile(id);
//        String mediaType = "application/octet-stream";
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(mediaType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ((UrlResource) resource).getFilename() + "\"")
//                .body(resource);
//    }

    @PostMapping("/files")
    public ResponseEntity<Object> uploadFile(@RequestBody MultipartFile file) {
        fileUploadService.uploadFile(file);
        return ResponseEntity.ok("Added");
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable("id") long id) {
        fileUploadService.deleteFile(id);
        return ResponseEntity.noContent().build().ok("Deleted");
    }
}