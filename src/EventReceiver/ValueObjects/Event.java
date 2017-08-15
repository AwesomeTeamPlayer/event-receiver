package EventReceiver.ValueObjects;

import org.json.JSONObject;
import java.util.Date;

public class Event
{
    private String name;

    private Date occurredAt;

    private JSONObject data;

    public Event(String name, Date occuredAt, JSONObject data)
    {
        this.name = name;
        this.occurredAt = occuredAt;
        this.data = data;
    }

    public String getName()
    {
        return name;
    }

    public Date getOccurredAt()
    {
        return occurredAt;
    }

    public JSONObject getData()
    {
        return data;
    }

    public JSONObject toJson()
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", this.name);
        jsonObject.put("occurredAt", this.occurredAt);
        jsonObject.put("data", this.data);

        return jsonObject;
    }
}
