package EventReceiver.ValueObjects;

import org.json.JSONObject;
import java.util.Date;

public class Event
{
    private final String name;
    private final Date occurredAt;
    private final JSONObject data;

    public Event(String name)
    {
        this.name = name;
        this.occurredAt = new Date();
        this.data = new JSONObject();
    }

    public Event(String name, Date occurredAt)
    {
        this.name = name;
        this.occurredAt = occurredAt;
        this.data = new JSONObject();
    }

    public Event(String name, Date occurredAt, JSONObject data)
    {
        this.name = name;
        this.occurredAt = occurredAt;
        this.data = data;
    }

    public String getName()
    {
        return this.name;
    }

    public Date getOccurredAt()
    {
        return this.occurredAt;
    }

    public JSONObject getData()
    {
        return this.data;
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
