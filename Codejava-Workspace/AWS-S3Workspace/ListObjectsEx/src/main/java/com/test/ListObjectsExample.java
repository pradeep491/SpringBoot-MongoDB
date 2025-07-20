package com.test;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.List;

public class ListObjectsExample {
    public static void main(String[] args) {
        Region region = Region.US_EAST_2;
        S3Client client = S3Client.builder().region(region).build();

        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        ListBucketsResponse listBuckets = client.listBuckets(listBucketsRequest);

        List<Bucket> buckets = listBuckets.buckets();

        for (Bucket bucket : buckets) {
            System.out.println(bucket.name() + " - " + bucket.creationDate());
        }
    }
}
