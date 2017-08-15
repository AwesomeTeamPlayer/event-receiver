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

    public boolean tryParse(Event event)
    {
        for (EventParserInterface eventParser : this.eventParsersList) {
            if (eventParser.getEventName().equals(event.getName())) {
                eventParser.execute(event);
                return true;
            }
        }

        return false;
    }
}
