package ch05_api.http2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class Http2IntroExample
{
    public static void main(final String[] args) throws Exception
    {
        var uri = new URI("https://www.oracle.com/");

        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        var asString = HttpResponse.BodyHandlers.ofString();
        
        var response = httpClient.send(request, asString);

        printResponseInfo(response);
    }

    private static void printResponseInfo(final HttpResponse<String> response)
    {
        final int responseCode = response.statusCode();
        final String responseBody = response.body();
        final HttpHeaders headers = response.headers();
        
        System.out.println("Status:  " + responseCode);
        if (responseCode == 200)
        {
            System.out.println("Body:    " + responseBody.substring(0, 1000));
            System.out.println("Headers: " + headers.map());
        }
    }
}