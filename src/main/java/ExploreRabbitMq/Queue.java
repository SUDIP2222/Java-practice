package ExploreRabbitMq;

import com.google.common.collect.ImmutableMap;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import static ExploreRabbitMq.Constant.AppConstant.HOST;
import static ExploreRabbitMq.Constant.AppConstant.CHANNEL;
import static ExploreRabbitMq.Constant.AppConstant.CONNECTION;

public class Queue {

    private static Queue queue;

    private Queue() {

    }

    public static Queue getQueueInstance() {
        if (Objects.isNull(queue)) {
            queue = new Queue();
        }
        return queue;
    }

    public Map<String, Object> queueConnection(String queueName) throws TimeoutException, IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(HOST);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
        ImmutableMap<String, Object> immutableMap = ImmutableMap.of(CHANNEL, channel, CONNECTION, connection);
        return immutableMap;
    }

}
