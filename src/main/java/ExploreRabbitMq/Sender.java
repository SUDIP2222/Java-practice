package ExploreRabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import static ExploreRabbitMq.Constant.AppConstant.CHANNEL;
import static ExploreRabbitMq.Constant.AppConstant.QUEUE_NAME;
import static ExploreRabbitMq.Constant.AppConstant.CONNECTION;

public class Sender {
    public static void main(String args[]) {

        try {
            Map channelAndConnectionMap = Queue.getQueueInstance().queueConnection(QUEUE_NAME);
            Channel channel = (Channel) channelAndConnectionMap.get(CHANNEL);
            Connection connection = (Connection) channelAndConnectionMap.get(CONNECTION);

            JsonConverter jsonConverter = new JsonConverter();
            UserMessage userMessage = new UserMessage("Sudip", "sudipdiu@gmail.com", "Hello RabbitMq");
            String userMessageJson = jsonConverter.objectToJsonConvert(userMessage);

            channel.basicPublish("", QUEUE_NAME, null, userMessageJson.getBytes());
            System.out.println("Json Message Sent ....");

            channel.close();
            connection.close();
        } catch (TimeoutException | IOException ex) {
            //log or throw
        }

    }
}
