package EventReceiver;

import EventReceiver.Exceptions.IncorrectJsonException;
import EventReceiver.ValueObjects.Event;

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

    public void handleMessage(String message) throws Exception
    {
        Event event;
        try {
            event = stringToEventParser.parseToEvent(message);
        } catch (IncorrectJsonException e) {
            System.out.println("Event in incorrect format: >>" + message + "<<\n");
            return;
        }

        boolean isParsed = this.eventsCollection.tryParse(event);
        if (isParsed == false) {
            System.out.println("Event was not parsed: " + event.toJson().toString());
        }
    }
}
