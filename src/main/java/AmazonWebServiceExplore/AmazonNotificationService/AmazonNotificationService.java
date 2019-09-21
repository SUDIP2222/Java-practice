package AmazonWebServiceExplore.AmazonNotificationService;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;

import java.util.Objects;

import static AmazonWebServiceExplore.AmazonAccessKey.*;

public class AmazonNotificationService {

    public static AmazonNotificationService amazonNotificationService;

    private AmazonNotificationService() {
    }

    public static AmazonNotificationService getNotificationInstance() {
        if (Objects.isNull(amazonNotificationService)) {
            amazonNotificationService = new AmazonNotificationService();
        }
        return amazonNotificationService;
    }

    public AmazonSNS getAmazonNotificationServicelient() {
        // When use IAM role
        /* return AmazonSNSClientBuilder
                 .standard()
                 .withCredentials(new InstanceProfileCredentialsProvider(true))
                 .build(); */
        BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AmazonSNSClient
                .builder()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .build();

    }

    public CreateTopicResult createTopic(final String topicName) {
        final CreateTopicRequest createTopicRequest = new CreateTopicRequest(topicName);
        return getAmazonNotificationServicelient().createTopic(createTopicRequest);
    }

    public boolean subscribeNotificationTopic(final String topicArn, final String email) {
        final SubscribeRequest subscribeRequest = new SubscribeRequest(topicArn, "email", email);
        getAmazonNotificationServicelient().subscribe(subscribeRequest);
        return true;
    }

    public boolean publishMessage(final String topicArn, final String message) {
        final PublishRequest publishRequest = new PublishRequest(topicArn, message);
        getAmazonNotificationServicelient().publish(publishRequest);
        return true;
    }

    public Boolean deleteTopic(final String topicArn) {
        final DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
        getAmazonNotificationServicelient().deleteTopic(deleteTopicRequest);
        return true;
    }

}
