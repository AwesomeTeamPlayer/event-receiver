package EventReceiver;

public class HttpRequestMakersCollection
{
    private HttpRequestMaker userService = new HttpRequestMaker("user-service", 8001);

    public HttpRequestMaker getUserServiceRequestMaker()
    {
        return this.userService;
    }
}
