package EventReceiver;

import EventReceiver.Exceptions.IncorrectJsonException;
import EventReceiver.ValueObjects.Event;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class StringToEventParser
{
    public Event parseToEvent(String json) throws IncorrectJsonException
    {
        try {
            JSONObject jsonObject = new JSONObject(json);
            String eventName = jsonObject.getString("name"  );
            String occurredAt = jsonObject.getString("occurredAt");
            JSONObject data = jsonObject.getJSONObject("data");

            return new Event(
                eventName,
                ISODateTimeFormat.dateTime().parseDateTime(occurredAt).toDate(),
                data
            );
        }
        catch (JSONException e) {
            throw new IncorrectJsonException();
        }
    }
}
