package ch05_api.http2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class Http2DownloadExample
{
    public static void main(final String[] args) throws Exception
    {
        var uri = new URI("https://www.oracle.com/");
        
        var request = HttpRequest.newBuilder(uri).GET().build();

        var downloadPath = Paths.get("oracle-index.html");
        var asFile = HttpResponse.BodyHandlers.ofFile(downloadPath);

        var httpClient = HttpClient.newHttpClient();
        var response = httpClient.send(request, asFile);
        
        if (response.statusCode() == 200)
        {
            System.out.println("Content written to file: " + 
                               downloadPath.toAbsolutePath());
        }
    }
}
