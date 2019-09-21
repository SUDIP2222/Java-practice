package AmazonWebServiceExplore.AmazonS3Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static AmazonWebServiceExplore.AmazonAccessKey.*;

public class AmazonS3Service {

    public static AmazonS3Service amazonS3Service;

    private AmazonS3Service() {
    }

    public static AmazonS3Service getAmazonS3ServiceInstance() {
        if (Objects.isNull(amazonS3Service)) {
            amazonS3Service = new AmazonS3Service();
        }
        return amazonS3Service;
    }

    public AmazonS3 getAmazonS3elient() {
        /* use IAM role
           return AmazonS3ClientBuilder
                 .standard()
                 .withCredentials(new InstanceProfileCredentialsProvider(true))
                 .build(); */
        BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AmazonS3Client
                .builder()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .build();

    }

    public Bucket createBucketByName(final String bucketName) {
        if (getAmazonS3elient().doesBucketExistV2(bucketName)) {
            System.out.println("bucket All ready Exists");
        }
        return getAmazonS3elient().createBucket(bucketName);
    }

    public PutObjectResult uploadObject(String bucketName, String keyName, String filePath) {
        return getAmazonS3elient().putObject(bucketName, keyName, new File(filePath));
    }

    public Boolean objectsList(String bucketName) {
        ListObjectsV2Result result = getAmazonS3elient().listObjectsV2(bucketName);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        objects.forEach(object -> {
            System.out.println("* " + object.getKey());
        });
        return true;
    }


    public Boolean BucketsList() {
        List<Bucket> buckets = getAmazonS3elient().listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        buckets.forEach(bucket -> {
            System.out.println("* " + bucket.getName());
        });

        return true;
    }

    public Boolean downloadObject(String bucketName, String keyName) {
        try {
            S3Object o = getAmazonS3elient().getObject(bucketName, keyName);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(keyName));
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return true;
    }

    public Boolean deleteObjectsByBucketName(final String bucketName) {
        ObjectListing objectListing = getAmazonS3elient().listObjects(bucketName);
        while (true) {
            for (Iterator<?> iterator = objectListing.getObjectSummaries().iterator(); iterator.hasNext(); ) {
                S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
                getAmazonS3elient().deleteObject(bucketName, summary.getKey());
            }
            if (objectListing.isTruncated()) {
                objectListing = getAmazonS3elient().listNextBatchOfObjects(objectListing);
            } else {
                break;
            }
        }

        return true;
    }

    public Boolean removeVersionsByBucketName(final String bucketName) {
        VersionListing versionListing = getAmazonS3elient().listVersions(new ListVersionsRequest()
                .withBucketName(bucketName));
        while (true) {
            for (Iterator<?> iterator = versionListing.getVersionSummaries().iterator(); iterator.hasNext(); ) {
                S3VersionSummary vs = (S3VersionSummary) iterator.next();
                getAmazonS3elient().deleteVersion(bucketName, vs.getKey(), vs.getVersionId());
            }
            if (versionListing.isTruncated()) {
                versionListing = getAmazonS3elient().listNextBatchOfVersions(versionListing);
            } else {
                break;
            }
        }

        return true;
    }

    public Boolean deleteBucketByBucketName(final String bucketName) {
        getAmazonS3elient().deleteBucket(bucketName);
        return true;
    }


    public Boolean deleteBucketbject(String bucketName, String keyName) {
        try {
            getAmazonS3elient().deleteObject(bucketName, keyName);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        return true;
    }

    public Boolean deleteMultipleObjects(String bucketName, String[] objectKeys) {
        try {
            DeleteObjectsRequest dor = new DeleteObjectsRequest(bucketName).withKeys(objectKeys);
            getAmazonS3elient().deleteObjects(dor);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        return true;
    }



}
