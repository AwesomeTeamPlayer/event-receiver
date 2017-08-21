package EventReceiver;

public class HttpRequestMakersCollection
{
    private HttpRequestMaker userService = new HttpRequestMaker("user-service", 8001);
    private HttpRequestMaker sourceListener = new HttpRequestMaker("source-listener", 8002);

    public HttpRequestMaker getUserServiceRequestMaker()
    {
        return this.userService;
    }

    public HttpRequestMaker getSourceListenerRequestMaker()
    {
        return this.sourceListener;
    }
}
