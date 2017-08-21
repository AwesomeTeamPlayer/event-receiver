package EventReceiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main
{
    public static void main(String[] args) throws InterruptedException, IOException, TimeoutException
    {
        if (args.length < 5) {
            System.out.println("Required arguments:");
            System.out.println(" - rabbit host");
            System.out.println(" - rabbit port");
            System.out.println(" - rabbit username");
            System.out.println(" - rabbit password");
            System.out.println(" - rabbit channel name");

            System.exit(1);
        }

        RabbitConnectionData rabbitConnectionData = new RabbitConnectionData(
            args[0],
            Integer.parseInt(args[1]),
            args[2],
            args[3]
        );

        String channelName = args[4];

        System.out.println("Try to connect:");
        System.out.println("  Host: " + rabbitConnectionData.getHost());
        System.out.println("  Port: " + rabbitConnectionData.getPort());
        System.out.println("  Username: " + rabbitConnectionData.getUsername());
        System.out.println("  Password: " + rabbitConnectionData.getPassword());
        System.out.println("  Channel: " + channelName);

        int waitingTimeInMilliseconds = 1000;

        Connector connector = new Connector(
            new StringToEventParser(),
            new ClientsCollection()
        );
        connector.connectToChannel(
            rabbitConnectionData,
            channelName,
            waitingTimeInMilliseconds
        );

        System.out.println(" [*] Waiting for messages");
    }
}
