package EventReceiver;

import com.rabbitmq.client.*;
import java.io.IOException;

public class GeneralConsumer implements Consumer
{
    private final Channel channel;
    private volatile String consumerTag;
    private MessageHandler messageHandler;

    public GeneralConsumer(
        Channel channel,
        MessageHandler messageHandler
    )
    {
        this.channel = channel;
        this.messageHandler = messageHandler;
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

        try {
            this.messageHandler.handleMessage(message);
            this.channel.basicAck(envelope.getDeliveryTag(), false);
        } catch (Exception exception) {
            System.out.println(" The exception occurred during the process" + exception.getMessage());
            exception.printStackTrace();
        }
    }
}
