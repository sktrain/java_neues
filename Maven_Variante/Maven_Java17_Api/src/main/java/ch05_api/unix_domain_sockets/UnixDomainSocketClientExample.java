package ch05_api.unix_domain_sockets;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class UnixDomainSocketClientExample
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        String userHome = System.getProperty("user.home");
        var socketPath = Path.of(userHome).resolve("my.socket");
        var socketAddress = UnixDomainSocketAddress.of(socketPath);

        var unixSocketProtocol = StandardProtocolFamily.UNIX;
        try (var socketChannel = SocketChannel.open(unixSocketProtocol))
        {
            socketChannel.connect(socketAddress);

            socketChannel.write(createMsg("Unix domain sockets"));
            Thread.sleep(1_000);
            socketChannel.write(createMsg("are a nice feature"));
            Thread.sleep(1_000);
            socketChannel.write(createMsg("End of Transmission"));
        }
    }

    private static ByteBuffer createMsg(String message)
    {
        var byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        return byteBuffer;
    }
}
