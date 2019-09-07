package ExploreRabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import static ExploreRabbitMq.Constant.AppConstant.QUEUE_NAME;
import static ExploreRabbitMq.Constant.AppConstant.CHANNEL;

public class Receiver {
    public static void main(String args[]) {

        try {
            Map channelAndConnectionMap = Queue.getQueueInstance().queueConnection(QUEUE_NAME);
            Channel channel = (Channel) channelAndConnectionMap.get(CHANNEL);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String getMessageFromQueue = new String(delivery.getBody(), "UTF-8");
                UserMessage userMessage = new JsonConverter().jsonToObjectConvert(getMessageFromQueue);

                System.out.println("Name : " + userMessage.getName());
                System.out.println("Email : " + userMessage.getEmail());
                System.out.println("Message : " + userMessage.getMessage());

            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });

        } catch (TimeoutException | IOException ex) {
            //log or throw
        }
    }
}
