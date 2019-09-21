package AmazonWebServiceExplore.AmazonNotificationService;

import com.amazonaws.services.sns.model.CreateTopicResult;

public class NotitificationServiceTest {
    public static void main(String args[]) {
        AmazonNotificationService amazonNotificationService = AmazonNotificationService.getNotificationInstance();
        CreateTopicResult createTopicResult = amazonNotificationService.createTopic("Test");
        amazonNotificationService.subscribeNotificationTopic(createTopicResult.getTopicArn(), "sudipdiu@gmail.com");
        /**
        * @param topicArn Send SNS topicArn String
        * @param message  messag
        * @return boolean
        */
        amazonNotificationService.publishMessage(createTopicResult.getTopicArn(), "Hello SNS");
    }
}
