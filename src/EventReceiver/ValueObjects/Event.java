package EventReceiver.ValueObjects;

import org.json.JSONObject;
import java.util.Date;

public class Event
{
    private String name;
    private Date occurredAt;
    private JSONObject data;

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
