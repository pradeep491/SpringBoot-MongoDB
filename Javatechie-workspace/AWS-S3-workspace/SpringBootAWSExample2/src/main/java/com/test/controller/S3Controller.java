package com.test.controller;

import com.test.service.S3Service;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/s3")
@Slf4j
@Validated
public class S3Controller {
    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }


    @GetMapping("/read-file")
    public ResponseEntity<byte[]> readFile(@RequestParam("fromDate") @DateTimeFormat LocalDate fromDate,
                                           @RequestParam String fileName) throws IOException {
        byte fileData[] = s3Service.readFileFromS3("punnujasvin", fromDate.getYear(), fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment,filename=\"" + fileName + "\"").body(fileData);
    }

    //http://localhost:9090/s3/does-folder-exist?folderName=2027&fromDate=2025-05-01&rFirmCode=DG0000000123
    //this is working
    @GetMapping("/does-folder-exist")
    public ResponseEntity<String> doesFolderExist(
            @RequestParam(required = true, defaultValue = "2025/") String folderName
            , @RequestParam("fromDate") @DateTimeFormat LocalDate fromDate
            , @RequestParam(value = "rFirmCode", required = true) @Pattern(regexp = "^[a-zA-Z0-9]+$") @Size(max=12) String recipientFirmCode) {
        String year = String.valueOf(fromDate.getYear());

        folderName = year + "/" + recipientFirmCode + "/";
        System.out.println("folder name is:" + folderName);
        //boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        if (!result) {
            log.info("folder does not exist with the name:{}",folderName);
            return ResponseEntity.ok("folder does not exists");
        }
        return ResponseEntity.ok("folder exists");
    }

    //this is not working
    @GetMapping("/does-folder-exist1")
    public ResponseEntity<String> doesFolderExist1(
            @RequestParam(required = true, defaultValue = "2025/") String folderName) {
        System.out.println("folder name is-" + folderName);
        boolean result = s3Service.doesSubfolderExist("punnujasvin", folderName);
        if (!result) {
            return ResponseEntity.ok("folder does not exists");
        }
        return ResponseEntity.ok("folder exists");
    }

    //http://localhost:9090/s3/read-file1?folderName=2025/file-test.txt
    @GetMapping("/read-file1")
    public ResponseEntity<String> readFile(@RequestParam(required = true, defaultValue = "2025/") String folderName) throws IOException {
        String str = s3Service.readFileFromS3("punnujasvin", folderName);
        System.out.println("control came here-" + str);
        return ResponseEntity.ok(str);
    }

    //cross checking with date folder
    @GetMapping("/does-folder-exist2")
    public ResponseEntity<String> doesFolderExist2(
            @RequestParam(required = true, defaultValue = "2025/") String folderName
            , @RequestParam("fromDate") @DateTimeFormat LocalDate fromDate
            , @RequestParam(value = "rFirmCode", required = true) String recipientFirmCode) {
        String year = String.valueOf(fromDate.getYear());

        //String prefix = fromDate.format(DateTimeFormatter.ISO_DATE) + "/";
        //folderName = year + "/" + recipientFirmCode + "/" + prefix;
        folderName = year + "/" + recipientFirmCode + "/" + fromDate+"/";
        System.out.println("folder name is:" + folderName);
        //boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        s3Service.listObjectsInBucket("punnujasvin", folderName);
        if (!result) {
            return ResponseEntity.ok("folder does not exists");
        }
        return ResponseEntity.ok("folder exists");
    }
    @GetMapping("/getDates")
    public ResponseEntity<List<LocalDate>> getDates(
            @RequestParam("fromDate") @DateTimeFormat LocalDate fromDate,
            @RequestParam("toDate") @DateTimeFormat LocalDate toDate){
            List<LocalDate> dates = s3Service.getDatesBetween(fromDate, toDate);
            return ResponseEntity.ok(dates);
    }
    @GetMapping("/copyFiles")
    public ResponseEntity<String> copyFiles(){
        String sourceBucket = "punnujasvin";
        String sourceKey = "2025/DG0000000123/2025-05-01/file-text.txt";
        //String destinationBucket = "jasvintest";
        String destinationBucket = "punnujasvin";
        String destinationKey = "Test/file-text.txt";
        s3Service.copyFile(sourceBucket, sourceKey,destinationBucket,destinationKey);
        return ResponseEntity.ok("files are copied successfully...!");
    }

    @GetMapping("/does-folder-exist3")
    public ResponseEntity<String> doesFolderExist3(
            @RequestParam(required = true, defaultValue = "2025/") String folderName
            , @RequestParam("fromDate") @DateTimeFormat LocalDate fromDate
            , @RequestParam(value = "rFirmCode", required = true) String recipientFirmCode) {
        String year = String.valueOf(fromDate.getYear());

        folderName = "archive/outbound/"+recipientFirmCode+"/"+year + "/";
        System.out.println("folder name is:" + folderName);
        //boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        boolean result = s3Service.doesFolderExist("punnujasvin", folderName);
        if (!result) {
            log.info("folder does not exist with the name:{}",folderName);
            return ResponseEntity.ok("folder does not exists");
        }
        return ResponseEntity.ok("folder exists");
    }
    @GetMapping("/copyFilesByUnzip")
    public ResponseEntity<String> copyFilesByUnzip() throws IOException {
        String sourceBucket = "punnujasvin";
        List<String> list = s3Service.listObjects(sourceBucket);
        log.info("list is-"+list);
        list.stream().forEach(key->{
            try {
                s3Service.unzipAndProcessFile(sourceBucket,key);
                //s3Service.uploadZippedContent(key.);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return ResponseEntity.ok("files are copied successfully...!");
    }

}
