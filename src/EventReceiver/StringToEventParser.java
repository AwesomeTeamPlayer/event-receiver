package EventReceiver;

import EventReceiver.ValueObjects.Event;
import org.json.JSONObject;

import java.util.Date;

public class StringToEventParser
{
    public Event parseToEvent(String json)
    {
        JSONObject jsonObject = new JSONObject(json);
        String evnetName = jsonObject.getString("event");
        String occuredAt = jsonObject.getString("occuredAt");
        JSONObject data = jsonObject.getJSONObject("data");

        return new Event(evnetName, new Date(), data);
    }
}
