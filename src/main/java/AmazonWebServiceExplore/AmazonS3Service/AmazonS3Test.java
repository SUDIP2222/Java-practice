package AmazonWebServiceExplore.AmazonS3Service;

import com.amazonaws.services.s3.model.Bucket;

import java.nio.file.Paths;

public class AmazonS3Test {
    public static void main(String args[]) {
        AmazonS3Service amazonS3Service = AmazonS3Service.getAmazonS3ServiceInstance();
        //amazonS3Service.CreateBucketByName("test-2-75839264859");
        Bucket bucket = amazonS3Service.createBucketByName("test-2-6784424642");
        String filePath = "FlePath";
        String keyName = Paths.get(filePath).getFileName().toString();

        amazonS3Service.uploadObject(bucket.getName(), keyName, filePath);

        amazonS3Service.objectsList(bucket.getName());

        amazonS3Service.downloadObject(bucket.getName(), keyName);




    }
}
