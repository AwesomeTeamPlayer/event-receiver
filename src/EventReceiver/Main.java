package EventReceiver;

import EventReceiver.EventParsers.EchoEventParser;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        String hostAddress = "localhost";
        String channelName = "event";
        int waitingTimeInMilliseconds = 1000;

        EventsCollection eventsCollection = new EventsCollection();
        eventsCollection.add(new EchoEventParser());

        Connector connector = new Connector(
            new StringToEventParser(),
            eventsCollection
        );
        connector.connectToChannel(
            hostAddress,
            channelName,
            waitingTimeInMilliseconds
        );

        System.out.println(" [*] Waiting for messages");
    }
}
