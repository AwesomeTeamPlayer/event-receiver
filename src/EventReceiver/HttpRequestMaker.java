package EventReceiver;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.*;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpRequestMaker
{
    private final HttpClient client = new HttpClient();

    private final String host;
    private final int port;

    public HttpRequestMaker(String host)
    {
        this.host = host;
        this.port = 80;
    }

    public HttpRequestMaker(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    public String getHost()
    {
        return this.host;
    }

    public int getPort()
    {
        return this.port;
    }

    public String makeGetRequest(String endpoint) throws IOException
    {
        GetMethod methodObject = new GetMethod("http://" + this.getHost() + ":" + this.getPort() + endpoint);

        return this.makeRequest(methodObject);
    }

    public String makePostRequest(String endpoint, JSONObject jsonObject) throws IOException
    {
        PostMethod methodObject = new PostMethod("http://" + this.getHost() + ":" + this.getPort() + endpoint);
        methodObject.setRequestEntity(new InputStreamRequestEntity(new ByteArrayInputStream(jsonObject.toString().getBytes(StandardCharsets.UTF_8))));

        return this.makeRequest(methodObject);
    }

    public String makePutRequest(String endpoint, JSONObject jsonObject) throws IOException
    {
        PutMethod methodObject = new PutMethod("http://" + this.getHost() + ":" + this.getPort() + endpoint);
        methodObject.setRequestEntity(new InputStreamRequestEntity(new ByteArrayInputStream(jsonObject.toString().getBytes(StandardCharsets.UTF_8))));

        return this.makeRequest(methodObject);
    }

    public String makeDeleteRequest(String endpoint, String body) throws IOException
    {
        DeleteMethod methodObject = new DeleteMethod("http://" + this.getHost() + ":" + this.getPort() + endpoint);
        return this.makeRequest(methodObject);
    }

    public String makeRequest(HttpMethodBase methodObject) throws IOException
    {
        this.client.executeMethod(methodObject);
        byte[] responseBody = methodObject.getResponseBody();
        return new String(responseBody);
    }
}
