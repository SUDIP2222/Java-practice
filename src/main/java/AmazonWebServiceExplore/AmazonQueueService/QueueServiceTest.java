package AmazonWebServiceExplore.AmazonQueueService;


import com.amazonaws.services.sqs.model.CreateQueueResult;

import static AmazonWebServiceExplore.AmazonQueueService.QueueConstant.QUEUE_NAME;

public class QueueServiceTest {
    public static void main(String args[]) {
        AmazonQueueService amazonQueueService = AmazonQueueService.getQueueInstance();
        CreateQueueResult createQueueResult = amazonQueueService.CreateQueue(QUEUE_NAME);
        amazonQueueService.sendMessageToQueue(createQueueResult.getQueueUrl(), "Java ForEver");
        amazonQueueService.receiveMessagesFromQueue(createQueueResult.getQueueUrl());


    }
}
