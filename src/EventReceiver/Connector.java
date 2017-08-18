package EventReceiver;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

class Connector
{
    private StringToEventParser stringToEventParser;
    private EventsCollection eventsCollection;

    public Connector(
        StringToEventParser stringToEventParser,
        EventsCollection eventsCollection
    )
    {
        this.stringToEventParser = stringToEventParser;
        this.eventsCollection = eventsCollection;
    }

    public Channel connectToChannel(
        RabbitConnectionData rabbitConnectionData,
        String channelName,
        int sleepInMilliseconds
    ) throws InterruptedException
    {
        ConnectionFactory factory = new ConnectionFactory();

        while (true) {
            this.wait(sleepInMilliseconds);

            try {
                factory.setHost(rabbitConnectionData.getHost());
                factory.setPort(rabbitConnectionData.getPort());
                factory.setPassword(rabbitConnectionData.getPassword());
                factory.setUsername(rabbitConnectionData.getUsername());

                factory.setExceptionHandler(new DefaultExceptionHandler());
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();

                System.out.println("Connected with RabbitMQ");

                GeneralConsumer consumer =  new GeneralConsumer(
                    channel,
                    new MessageHandler(
                        this.stringToEventParser,
                        this.eventsCollection
                    )
                );
                channel.basicConsume(channelName, true, consumer);
                return channel;
            } catch (AlreadyClosedException e) {
                System.out.println("Connection is closed");
            } catch (ShutdownSignalException e) {
                System.out.println("Lost connection with host " + rabbitConnectionData.getHost());
            } catch (UnknownHostException e) {
                System.out.println("Unknown Host " + rabbitConnectionData.getHost());
            } catch ( IOException | TimeoutException e) {
            }
        }
    }

    private void wait(int sleepInMilliseconds) throws InterruptedException
    {
        Thread.sleep(sleepInMilliseconds);
        System.out.println("\nWait " + sleepInMilliseconds + " ms");
    }
}
