package EventReceiver;

import EventReceiver.ValueObjects.Event;
import org.json.JSONException;

public class MessageHandler
{
    private StringToEventParser stringToEventParser;
    private EventsCollection eventsCollection;

    public MessageHandler(
        StringToEventParser stringToEventParser,
        EventsCollection eventsCollection
    )
    {
        this.stringToEventParser = stringToEventParser;
        this.eventsCollection = eventsCollection;
    }

    public void handleMessage(String message)
    {
        Event event;
        try {
            event = stringToEventParser.parseToEvent(message);
        } catch (JSONException e) {
            System.out.println("Event in incorrect format: >>" + message + "<<\n");
            return;
        }
        this.eventsCollection.tryParse(event);
    }
}
