package com.test.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.test.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/s3")
public class S3Controller {
    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    /* @GetMapping("/{key}")
     public ResponseEntity<byte[]> getObject(@PathVariable("key") String key) {
         byte[] objectBytes = s3Service.getObject(key);
         if (objectBytes != null) {
             HttpHeaders headers = new HttpHeaders();
             headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
             headers.setContentLength(objectBytes.length);
             headers.setContentDispositionFormData("attachment", key);
             return new ResponseEntity<>(objectBytes, headers, HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }

     @PostMapping("/{key}")
     public ResponseEntity<String> createObject(@PathVariable("key") String key, @RequestBody MultipartFile file) {
         try {
             s3Service.createObject(key, file);
             return new ResponseEntity<>("Object created successfully", HttpStatus.CREATED);
         } catch (IOException e) {
             return new ResponseEntity<>("Error creating object: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }

     @PutMapping("/{key}")
     public ResponseEntity<String> updateObject(@PathVariable("key") String key, @RequestBody MultipartFile file) {
         try {
             s3Service.updateObject(key, file);
             return new ResponseEntity<>("Object updated successfully", HttpStatus.OK);
         } catch (IOException e) {
             return new ResponseEntity<>("Error updating object: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }

     @DeleteMapping("/{key}")
     public ResponseEntity<String> deleteObject(@PathVariable("key") String key) {
         s3Service.deleteObject(key);
         return new ResponseEntity<>("Object deleted successfully", HttpStatus.OK);
     }*/
    @GetMapping("/listS3Buckets")
    public ResponseEntity<List<Bucket>> listS3Buckets() {
        return ResponseEntity.of(Optional.ofNullable(s3Service.listBuckets()));
    }

    @GetMapping("/listAllObjects")
    public ResponseEntity<List<String>> viewObjects() {
        return new ResponseEntity<>(s3Service.listObjects(), HttpStatus.OK);
    }

    @GetMapping("/read-file")
    public ResponseEntity<byte[]> readFile(@RequestParam("fromDate") @DateTimeFormat LocalDate fromDate,
                                           @RequestParam String fileName) throws IOException {
        System.out.println("Sub folder name is-"+fromDate.getYear());
        byte fileData[] = s3Service.readFileFromS3("punnujasvin", fromDate.getYear(), fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment,filename=\"" + fileName + "\"").body(fileData);
    }
    @GetMapping("/readFile")
    public byte[] readFile1(@RequestParam("fromDate") @DateTimeFormat LocalDate fromDate,
                                           @RequestParam String fileName) throws IOException {

        byte fileData[] = s3Service.getObjectFromS3Subfolder("punnujasvin", String.valueOf(fromDate.getYear())+"/", fileName);
        return fileData;
    }
}
