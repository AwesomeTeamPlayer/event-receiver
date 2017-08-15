package EventReceiver.EventParsers;

import EventReceiver.ValueObjects.Event;

public interface EventParserInterface
{
    String getEventName();

    void execute(Event event);
}
