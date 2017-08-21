package EventReceiver.Clients;

import EventReceiver.HttpRequestMaker;
import org.json.JSONObject;
import java.io.IOException;

public class SourceListenerClient
{
    private final HttpRequestMaker sourceListener;

    public SourceListenerClient(HttpRequestMaker sourceListener)
    {
        this.sourceListener = sourceListener;
    }

    public void registerClient(String clientId, String sourceId)  throws IOException
    {
        JSONObject json = new JSONObject();

        json.put("clientId", clientId);
        json.put("sourceId", sourceId);

        this.sourceListener.makePostRequest(
           "register-client",
            json
        );
    }

    public void unregisterClient(String clientId, String sourceId) throws IOException
    {
        JSONObject json = new JSONObject();

        json.put("clientId", clientId);
        json.put("sourceId", sourceId);

        this.sourceListener.makePostRequest(
                "unregister-client",
                json
        );
    }

    public void informClients(String sourceId, String message) throws IOException
    {
        JSONObject json = new JSONObject();

        json.put("message", message);
        json.put("sourceId", sourceId);

        this.sourceListener.makePostRequest(
                "inform-client",
                json
        );
    }
}
