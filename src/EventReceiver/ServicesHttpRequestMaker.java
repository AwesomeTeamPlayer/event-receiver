package EventReceiver;

public class ServicesHttpRequestMaker
{
    private HttpRequestMaker userService = new HttpRequestMaker("user-service", 8001);;

    public HttpRequestMaker getUserServiceRequestMaker()
    {
        return this.userService;
    }
}
