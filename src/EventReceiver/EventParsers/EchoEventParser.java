package EventReceiver.EventParsers;

import EventReceiver.RabbitQueueConnection;
import EventReceiver.ValueObjects.Event;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class EchoEventParser implements EventParserInterface
{
    private final RabbitQueueConnection rabbitMqConnector;

    public EchoEventParser(RabbitQueueConnection rabbitMqConnector)
    {
        this.rabbitMqConnector = rabbitMqConnector;
    }

    public String getEventName()
    {
        return "EchoEventParser";
    }

    @Override
    public boolean execute(Event event) throws Exception
    {
        try {
            this.rabbitMqConnector.publish(new Event("EchoEventParserExecuted", new Date(), new JSONObject()));
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
