package com.test.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3Service {
    private final AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    public S3Service(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> listObjects() {
        String delimiter = "/";
        String key = "2025/";
        ObjectListing objectListing = s3Client.listObjects(bucketName);
        //ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        //ObjectListing objectListing = s3Client.listObjects(bucketName);
        //ObjectListing objectListing = s3Client.listObjects(listObjectsRequest);
        return objectListing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }

    public void uploadFile(MultipartFile file) throws IOException {
        s3Client.putObject(new PutObjectRequest(bucketName, file.getOriginalFilename(), file.getInputStream(), null));
    }

    public S3Object downloadFile(String fileName) {
        return s3Client.getObject(new GetObjectRequest(bucketName, fileName));
    }

    public void deleteFile(String fileName) {
        s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
    }
    public ObjectListing listObjectsInBucket(String bucketName) {
        return s3Client.listObjects(bucketName);
    }

    public void printObjectKeys(String bucketName) {
        ObjectListing objectListing = s3Client.listObjects(bucketName);
        for (S3ObjectSummary summary : objectListing.getObjectSummaries()) {
            System.out.println("Object Key: " + summary.getKey());
        }
    }
    public List<Bucket> listBuckets() {
        return s3Client.listBuckets();
    }
    public List<String> listObjects1() {
        ObjectListing objectListing=s3Client.listObjects(bucketName);
        return objectListing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }
    public byte[] readFileFromS3(String bucketName,int subfolder,String fileName) throws IOException {
        String key = subfolder+"/"+fileName;
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName,key);
        S3Object s3Object = s3Client.getObject(getObjectRequest);
        return IOUtils.toByteArray(s3Object.getObjectContent());
    }
    public byte[] getObjectFromS3(String bucketName, String key) throws IOException {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        S3Object s3Object = s3Client.getObject(getObjectRequest);
        return s3Object.getObjectContent().readAllBytes();
    }

    public byte[] getObjectFromS3Subfolder(String bucketName, String subfolder, String objectName) throws IOException {
        String key = subfolder + "/" + objectName;
        return getObjectFromS3(bucketName, key);
    }
}
