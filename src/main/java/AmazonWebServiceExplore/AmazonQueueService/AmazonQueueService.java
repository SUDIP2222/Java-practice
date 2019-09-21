package AmazonWebServiceExplore.AmazonQueueService;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.*;
import java.util.List;
import java.util.Objects;

import static AmazonWebServiceExplore.AmazonAccessKey.*;

public class AmazonQueueService {

    public static AmazonQueueService amazonQueueService;

    private AmazonQueueService() {
    }

    public static AmazonQueueService getQueueInstance() {
        if (Objects.isNull(amazonQueueService)) {
            amazonQueueService = new AmazonQueueService();
        }
        return amazonQueueService;
    }

    public AmazonSQS getAmazonQueueServicelient() {
        /* When use IAM role
           return AmazonSQSClientBuilder
                 .standard()
                 .withCredentials(new InstanceProfileCredentialsProvider(true))
                 .build(); */
        BasicAWSCredentials basicAwsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        return AmazonSQSClient
                .builder()
                .withRegion(REGION)
                .withCredentials(new AWSStaticCredentialsProvider(basicAwsCredentials))
                .build();

    }

    public CreateQueueResult CreateQueue(final String queueName) {
        CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
        return getAmazonQueueServicelient().createQueue(createQueueRequest);
    }

    public Boolean sendMessageToQueue(final String queueUrl, final String message) {
        getAmazonQueueServicelient().sendMessage(new SendMessageRequest(queueUrl, message));
        return true;
    }

    public Boolean receiveMessagesFromQueue(final String queueUrl) {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> messages = getAmazonQueueServicelient().receiveMessage(receiveMessageRequest).getMessages();
        messages.forEach(message -> {
            System.out.println("Message ::::::::::::::::::::::::");
            System.out.println("MessageId : " + message.getMessageId());
            System.out.println("ReceiptHandle : " + message.getReceiptHandle());
            System.out.println("MD5OfBody : " + message.getMD5OfBody());
            System.out.println("Body : " + message.getBody() + "\n");
        });
        return true;
    }

    public Boolean deleteQueue(final String queueUrl) {
        getAmazonQueueServicelient().deleteQueue(queueUrl);
        return true;
    }

}
