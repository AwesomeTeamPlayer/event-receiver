package EventReceiver;

import EventReceiver.ValueObjects.Event;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class RabbitQueueConnection
{
    private String eventChannelName;
    private Channel channel;

    public RabbitQueueConnection(
        String eventChannel,
        Channel channel
    )
    {
        this.eventChannelName = eventChannel;
        this.channel = channel;
    }

    public void publish(Event event) throws IOException
    {
        this.channel.basicPublish(
            "",
            this.eventChannelName,
            null,
            event.toJson().toString().getBytes()
        );
    }
}
