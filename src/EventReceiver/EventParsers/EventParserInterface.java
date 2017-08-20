package EventReceiver.EventParsers;

import EventReceiver.ValueObjects.Event;

public interface EventParserInterface
{
    String getEventName();

    boolean execute(Event event) throws Exception;
}
