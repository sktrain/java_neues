package ch05_api.unix_domain_sockets;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class UnixDomainSocketServerExample
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        String userHome = System.getProperty("user.home");
        var socketPath = Path.of(userHome).resolve("my.socket");

        // socket file kann nicht wiederverwendet werden und darf auch nicht existieren,
        // daher für "reinen Tisch" sorgen: Ansonsten bekommen man eine 
        // java.net.BindException: Address already in use
        Files.deleteIfExists(socketPath);
        
        var socketAddress = UnixDomainSocketAddress.of(socketPath);
        
        try (var serverChannel = 
             ServerSocketChannel.open(StandardProtocolFamily.UNIX))
        {
            serverChannel.bind(socketAddress);
        
            // einfache Variante, bei der sich nur ein Client verbinden kann
            System.out.println("Waiting for client to connect...");
            try (var socketChannel = serverChannel.accept())
            {
                System.out.println("Client connected");
              
                int elapsedTimeInMs = 0;
                while (elapsedTimeInMs < 10_000)
                {
                    var message = readMessage(socketChannel);
                    if (!message.isEmpty())
                    {
                        System.out.printf("Client send: %s%n", message);
                    }
                                        
                    Thread.sleep(100);
                    elapsedTimeInMs += 100;
                }
            }            
        }
    }

    private static String readMessage(SocketChannel channel) throws IOException
    {
        var byteBuffer = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(byteBuffer);
        
        // end of stream or no content
        if (bytesRead <= 0)
            return "";

        var bytes = new byte[bytesRead];
        byteBuffer.flip();
        byteBuffer.get(bytes);
        return new String(bytes);
    }
}
