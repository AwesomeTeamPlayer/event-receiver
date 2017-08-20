package EventReceiver.EventParsers;

import EventReceiver.RabbitQueueConnection;
import EventReceiver.HttpRequestMakersCollection;
import EventReceiver.ValueObjects.Event;

public class UserUpdatedEventParser implements EventParserInterface
{
    private final HttpRequestMakersCollection httpRequestMakerCollection;
    private final RabbitQueueConnection rabbitMqConnector;

    public UserUpdatedEventParser(
        HttpRequestMakersCollection servicesHttpRequestMakerCollection,
        RabbitQueueConnection rabbitMqConnector
    )
    {
        this.httpRequestMakerCollection = servicesHttpRequestMakerCollection;
        this.rabbitMqConnector = rabbitMqConnector;
    }

    public String getEventName()
    {
        return "UserUpdated";
    }

    public boolean execute(Event event) throws Exception
    {
        this.httpRequestMakerCollection
                .getUserServiceRequestMaker()
                .makeGetRequest("/");

        return true;
    }
}
