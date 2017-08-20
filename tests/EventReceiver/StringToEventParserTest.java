package EventReceiver;

import EventReceiver.Exceptions.IncorrectJsonException;
import EventReceiver.ValueObjects.Event;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToEventParserTest
{
    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_empty_string() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_incorrect_string() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("abc123");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_empty_json() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_without_name() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"occurredAt\":\"2012-01-02T03:04:05+06:07\", \"data\":{}}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_without_occurredAt() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"name\":\"name\", \"data\":{}}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_without_data() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"occurredAt\":\"2012-12-12 12:12:12\", \"name\":\"\"}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_with_incorrect_name() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"name\":{}, \"occurredAt\":\"2012-12-12 12:12:12\", \"data\":{}}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_with_incorrect_occurredAt() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"name\":\"name\", \"occurredAt\":{}, \"data\":{}}");
    }

    @Test(expected = IncorrectJsonException.class)
    public void test_parseToEvent_with_json_with_incorrect_data() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
        stringToEventParser.parseToEvent("{\"occurredAt\":\"2012-12-12 12:12:12\", \"name\":\"\", \"data\":\"\"}}");
    }

    @Test
    public void test_parseToEvent_with_correct_json() throws IncorrectJsonException
    {
        StringToEventParser stringToEventParser = new StringToEventParser();
            Event event = stringToEventParser.parseToEvent("{\"occurredAt\":\"2012-01-02T03:04:05.123+02:00\", \"name\":\"name\", \"data\":{\"a\":\"b\"}}}");
        assertEquals("name", event.getName());
        assertEquals((new JSONObject("{\"a\":\"b\"}").toString()), event.getData().toString());
        assertEquals(((long) 1325466245) * 1000 + 123, event.getOccurredAt().getTime());
    }

}