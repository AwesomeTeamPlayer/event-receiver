package EventReceiver;

import static org.mockito.Mockito.*;
import EventReceiver.EventParsers.EventParserInterface;
import EventReceiver.ValueObjects.Event;
import org.json.JSONObject;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventsCollectionTest
{
    @Test
    public void test_tryParse_when_collection_is_empty() throws Exception
    {
        EventsCollection eventsCollection = new EventsCollection();
        boolean result = eventsCollection.tryParse(
            new Event("name", new Date(), new JSONObject())
        );

        assertFalse(result);
    }

    @Test
    public void test_tryParse_when_collection_is_not_empty_but_there_is_not_matched_event_parser() throws Exception
    {
        EventParserInterface eventParser_0 = mock ( EventParserInterface. class );
        stub(eventParser_0.getEventName()).toReturn("xyz");

        EventParserInterface eventParser_1 = mock ( EventParserInterface. class );
        stub(eventParser_1.getEventName()).toReturn("abc");

        EventsCollection eventsCollection = new EventsCollection();
        eventsCollection.add(eventParser_0);
        eventsCollection.add(eventParser_1);

        boolean result = eventsCollection.tryParse(
            new Event("name", new Date(), new JSONObject())
        );

        assertFalse(result);
    }

    @Test
    public void test_tryParse_when_collection_is_not_empty_and_there_is_matched_event_parser() throws Exception
    {
        EventParserInterface eventParser_0 = mock ( EventParserInterface. class );
        stub(eventParser_0.getEventName()).toReturn("xyz");

        EventParserInterface eventParser_1 = mock ( EventParserInterface. class );
        stub(eventParser_1.getEventName()).toReturn("name");

        EventParserInterface eventParser_2 = mock ( EventParserInterface. class );
        stub(eventParser_2.getEventName()).toReturn("abc");

        EventsCollection eventsCollection = new EventsCollection();
        eventsCollection.add(eventParser_0);
        eventsCollection.add(eventParser_1);
        eventsCollection.add(eventParser_2);

        boolean result = eventsCollection.tryParse(
            new Event("name", new Date(), new JSONObject())
        );

        assertTrue(result);
    }

}