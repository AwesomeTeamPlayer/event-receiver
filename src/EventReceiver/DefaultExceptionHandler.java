package EventReceiver;

import com.rabbitmq.client.*;

public class DefaultExceptionHandler implements ExceptionHandler
{
    @Override
    public void handleUnexpectedConnectionDriverException(Connection connection, Throwable throwable)
    {
        System.out.println("Unexpected Connection Driver Exception occurred");
    }

    @Override
    public void handleReturnListenerException(Channel channel, Throwable throwable)
    {
        System.out.println("handleReturnListenerException");
    }

    @Override
    public void handleFlowListenerException(Channel channel, Throwable throwable)
    {
        System.out.println("handleFlowListenerException");
    }

    @Override
    public void handleConfirmListenerException(Channel channel, Throwable throwable)
    {
        System.out.println("handleConfirmListenerException");
    }

    @Override
    public void handleBlockedListenerException(Connection connection, Throwable throwable)
    {
        System.out.println("handleBlockedListenerException");
    }

    @Override
    public void handleConsumerException(Channel channel, Throwable throwable, Consumer consumer, String s, String s1)
    {
        System.out.println("handleConsumerException");
    }

    @Override
    public void handleConnectionRecoveryException(Connection connection, Throwable throwable)
    {
        System.out.println("We lost connection with " + connection.getAddress().getHostAddress() + ":" + connection.getPort());
        System.out.println("Try to reconnect\n");
    }

    @Override
    public void handleChannelRecoveryException(Channel channel, Throwable throwable)
    {
        System.out.println("handleChannelRecoveryException");
    }

    @Override
    public void handleTopologyRecoveryException(Connection connection, Channel channel, TopologyRecoveryException e)
    {
        System.out.println("handleTopologyRecoveryException");
    }
}
