package EventReceiver;

import EventReceiver.EventParsers.EventParserInterface;
import EventReceiver.ValueObjects.Event;
import org.json.JSONObject;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertFalse;

public class EventsCollectionTest
{
    @Test
    public void test_tryParse_when_collection_is_empty() {
        EventsCollection eventsCollection = new EventsCollection();
        boolean result = eventsCollection.tryParse(
            new Event("name", new Date(), new JSONObject())
        );

        assertFalse(result);
    }

}