package EventReceiver;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main
{
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException
    {
//        String queueName = "events";
//
//        Thread.sleep(2000);
//
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("events-rabbitmq");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(queueName, false, false, false, null);

        Connector connector = new Connector();
        connector.connectToChannel("localhost", 1000);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }
}
