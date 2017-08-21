package EventReceiver.EventParsers;

import EventReceiver.ClientsCollection;
import EventReceiver.ValueObjects.Event;

public class UserUpdatedEventParser implements EventParserInterface
{
    private final ClientsCollection clientsCollection;

    public UserUpdatedEventParser(ClientsCollection clientsCollection)
    {
        this.clientsCollection = clientsCollection;
    }

    public String getEventName()
    {
        return "UserUpdated";
    }

    public boolean execute(Event event) throws Exception
    {
        this.clientsCollection
            .getSourceListener()
            .informClients("users", event.getData().toString());

        return true;
    }
}
