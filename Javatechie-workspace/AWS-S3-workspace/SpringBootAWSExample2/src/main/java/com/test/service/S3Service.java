package com.test.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class S3Service {
    private final AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    public S3Service(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public byte[] readFileFromS3(String bucketName,int subfolder,String fileName) throws IOException {
        String key = subfolder+"/"+fileName;
        System.out.println("key is-"+key);
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName,key);
        S3Object s3Object = s3Client.getObject(getObjectRequest);
        return IOUtils.toByteArray(s3Object.getObjectContent());
    }
    //
    public boolean doesFolderExist(String bucketName,String folderPath){
        ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request()
                .withBucketName(bucketName)
                .withPrefix(folderPath);//folder path should end with "/"
        ListObjectsV2Result result = s3Client.listObjectsV2(listObjectsRequest);
        return result.getKeyCount()>0;
    }
    //this is not working
    public boolean doesSubfolderExist(String bucketName, String subfolderName) {
        ListObjectsV2Request request = new ListObjectsV2Request()
                .withBucketName(bucketName)
                .withPrefix(subfolderName + "/");
                //.withDelimiter("/");

        ListObjectsV2Result result = s3Client.listObjectsV2(request);

        //return !result.getCommonPrefixes().isEmpty();
        return result.getKeyCount()>0;
    }

    //To Read the file content - its working

    public String readFileFromS3(String bucketName, String key) throws IOException {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        S3Object s3Object = s3Client.getObject(getObjectRequest);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object.getObjectContent()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
    public void listObjectsInBucket(String bucketName,String folderPath) {

        ListObjectsV2Request listObjectsV2Request = new ListObjectsV2Request()
                .withBucketName(bucketName)
                .withPrefix(folderPath);
        ListObjectsV2Result result = s3Client.listObjectsV2(listObjectsV2Request);
        List<S3ObjectSummary> contents = result.getObjectSummaries();

        System.out.println("Number of objects in the bucket: " + contents.stream().count());
        contents.stream().forEach(System.out::println);

        //s3Client.shutdown();
    }
    public List<LocalDate> getDatesBetween(LocalDate fromDate, LocalDate toDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = fromDate;

        while (!currentDate.isAfter(toDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        System.out.println("dates are-"+dates);
        return dates;
    }
    public void copyFile(String sourceBucket, String sourceKey, String destinationBucket, String destinationKey) {
        //CopyObjectRequest copyObjRequest = new CopyObjectRequest(sourceBucket, sourceKey, destinationBucket, destinationKey);
        //s3Client.copyObject(copyObjRequest);
        s3Client.copyObject(sourceBucket, sourceKey,
                destinationBucket, destinationKey);
    }

    public void unzipAndProcessFile(String bucketName, String key) throws IOException {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        S3Object s3Object = s3Client.getObject(getObjectRequest);
        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();
        try (ZipInputStream zipInputStream = new ZipInputStream(objectInputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (!zipEntry.isDirectory()) {
                    String content = new String(zipInputStream.readAllBytes());
                    copyToS3(content, "punnujasvin", zipEntry.getName());
                    zipInputStream.closeEntry();
                }
            }
        }
    }
    public void copyToS3(String content,String destinationBucket,String destinationKey){
        s3Client.putObject(destinationBucket,destinationKey, content);
    }
    public List<String> listObjects(String bucketName) {
        ListObjectsV2Request request = new ListObjectsV2Request().withBucketName(bucketName);
        ListObjectsV2Result result;
        List<String> objectKeys = new ArrayList<>();

        do {
            result = s3Client.listObjectsV2(request);

            for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                objectKeys.add(objectSummary.getKey());
            }
            request.setContinuationToken(result.getNextContinuationToken());
        } while (result.isTruncated());

        return objectKeys;
    }
    public void uploadZippedContent(MultipartFile zipFile) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(zipFile.getInputStream())) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                if (!zipEntry.isDirectory()) {
                    String fileName = zipEntry.getName();
                    byte[] content = IOUtils.toByteArray(zis);
                    ObjectMetadata metadata = new ObjectMetadata();
                    metadata.setContentLength(content.length);
                    s3Client.putObject(bucketName, fileName, new ByteArrayInputStream(content), metadata);
                }
            }
        }
    }
}
