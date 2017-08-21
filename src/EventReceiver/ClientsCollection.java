package EventReceiver;

import EventReceiver.Clients.SourceListenerClient;

public class ClientsCollection
{
    private SourceListenerClient sourceListener = new SourceListenerClient(new HttpRequestMaker("source-listener", 8002));

    public SourceListenerClient getSourceListener()
    {
        return sourceListener;
    }
}
