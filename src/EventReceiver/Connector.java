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
        String hostAddress,
        String channelName,
        int sleepInMilliseconds
    ) throws InterruptedException
    {
        ConnectionFactory factory = new ConnectionFactory();

        while (true) {
            this.wait(sleepInMilliseconds);

            try {
                factory.setHost(hostAddress);
                factory.setExceptionHandler(new DefaultExceptionHandler());
                Connection connection = factory.newConnection();

                System.out.println("Connected with RabbitMQ");

                Channel channel = connection.createChannel();

                GeneralConsumer consumer =  new GeneralConsumer(
                    channel,
                    this.stringToEventParser,
                    this.eventsCollection
                );
                channel.basicConsume(channelName, true, consumer);
                return channel;
            } catch (AlreadyClosedException e) {
                System.out.println("Connection is closed");
            } catch (ShutdownSignalException e) {
                System.out.println("Lost connection with host " + hostAddress);
            } catch (UnknownHostException e) {
                System.out.println("Unknown Host " + hostAddress);
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
