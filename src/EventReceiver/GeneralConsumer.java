package EventReceiver;

import EventReceiver.ValueObjects.Event;
import com.rabbitmq.client.*;
import org.json.JSONException;

import java.io.IOException;

public class GeneralConsumer implements Consumer
{
    private final Channel channel;
    private volatile String consumerTag;
    private StringToEventParser stringToEventParser;
    private EventsCollection eventsCollection;

    public GeneralConsumer(
        Channel channel,
        StringToEventParser stringToEventParser,
        EventsCollection eventsCollection
    )
    {
        this.channel = channel;
        this.stringToEventParser = stringToEventParser;
        this.eventsCollection = eventsCollection;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getConsumerTag() {
        return this.consumerTag;
    }

    public void handleConsumeOk(String consumerTag)
    {
        this.consumerTag = consumerTag;
    }

    public void handleCancel(String s) throws IOException
    {
        System.out.println("handleCancel " + s);
    }

    public void handleCancelOk(String consumerTag)
    {
        System.out.println("handleCancelOk " + consumerTag);
    }

    public void handleShutdownSignal(String s, ShutdownSignalException e)
    {
        System.out.println("handleShutdownSignal " + s);
    }

    public void handleRecoverOk(String s)
    {
        System.out.println("handleRecoverOk " + s);
    }

    public void handleDelivery(
        String consumerTag,
        Envelope envelope,
        AMQP.BasicProperties properties,
        byte[] body
    ) throws IOException
    {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");

        Event event = null;
        try {
            event = stringToEventParser.parseToEvent(message);
        } catch (JSONException e) {
            System.out.println("Event in incorrect format: >>" + message + "<<");
            return;
        }
        this.eventsCollection.tryParse(event);
    }
}
