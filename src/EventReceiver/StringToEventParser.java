package EventReceiver;

import EventReceiver.Exceptions.IncorrectJsonException;
import EventReceiver.ValueObjects.Event;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class StringToEventParser
{
    public Event parseToEvent(String json) throws IncorrectJsonException
    {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String evnetName = jsonObject.getString("name");
            String occuredAt = jsonObject.getString("occurredAt");
            JSONObject data = jsonObject.getJSONObject("data");

            return new Event(evnetName, new Date(), data);
        }
        catch (JSONException e)
        {
            throw new IncorrectJsonException();
        }
    }
}
