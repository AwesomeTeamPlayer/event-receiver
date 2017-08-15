package EventReceiver;

import EventReceiver.EventParsers.EventParserInterface;
import EventReceiver.ValueObjects.Event;

import java.util.LinkedList;

public class EventsCollection
{
    private LinkedList<EventParserInterface> eventParsersList = new LinkedList();

    public void add(EventParserInterface event)
    {
        this.eventParsersList.add(event);
    }

    public void tryParse(Event event)
    {
        for (EventParserInterface eventParser : this.eventParsersList) {
            if (eventParser.getEventName().equals(event.getName())) {
                eventParser.execute(event);
                break;
            }
        }

        System.out.println("Event was not parsed: " + event.toJson().toString());
    }
}
