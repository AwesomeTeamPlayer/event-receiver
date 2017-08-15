package EventReceiver.ValueObjects;

import org.json.JSONObject;
import java.util.Date;

public class Event
{
    private String name;

    private Date occuredAt;

    private JSONObject data;

    public Event(String name, Date occuredAt, JSONObject data)
    {
        this.name = name;
        this.occuredAt = occuredAt;
        this.data = data;
    }

    public String getName()
    {
        return name;
    }

    public Date getOccuredAt()
    {
        return occuredAt;
    }

    public JSONObject getData()
    {
        return data;
    }
}
