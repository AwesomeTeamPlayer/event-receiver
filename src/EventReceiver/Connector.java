package EventReceiver;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

class Connector
{
    public Channel connectToChannel(String hostAddress, int sleepInMilliseconds) throws IOException
    {
        ConnectionFactory factory = new ConnectionFactory();

        while (true) {
            this.wait(sleepInMilliseconds);

            try {
                factory.setHost(hostAddress);
                Connection connection = factory.newConnection();

                System.out.println("Connected with RabbitMQ");
                return connection.createChannel();
            } catch (UnknownHostException e) {
                System.out.println("Unknown Host " + hostAddress);
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    private void wait(int sleepInMilliseconds)
    {
        try {
            Thread.sleep(sleepInMilliseconds);
            System.out.println("\nWait " + sleepInMilliseconds + " ms");
        } catch (InterruptedException e) {
        }
    }
}
