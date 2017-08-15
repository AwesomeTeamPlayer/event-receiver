package EventReceiver.EventParsers;

import EventReceiver.ValueObjects.Event;

public class EchoEventParser implements EventParserInterface
{
    public String getEventName()
    {
        return "EchoEventParser";
    }

    @Override
    public void execute(Event event)
    {
        System.out.println(event.getName());
    }
}
