package com.test;

public class ListObjectsExample1 {
    public void listObjects(){
        String bucketName = "nam-public-images";
        String folderName = "product-images";

        S3Client client = S3Client.builder().build();

        ListObjectsRequest request = ListObjectsRequest.builder()
                .bucket(bucketName)
                .prefix(folderName).build();

        ListObjectsResponse response = client.listObjects(request);
        List<S3Object> objects = response.contents();

        ListIterator<S3Object> listIterator = objects.listIterator();

        while (listIterator.hasNext()) {
            S3Object object = listIterator.next();
            System.out.println(object.key() + " - " + object.size());
        }
    }
}
