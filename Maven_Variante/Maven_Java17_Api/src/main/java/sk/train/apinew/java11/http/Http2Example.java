package sk.train.apinew.java11.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class Http2Example
{
    public static void main(final String[] args) throws Exception
    {
        readOraclePageJdk9();
    }

	private static void readOraclePageJdk9() throws URISyntaxException, IOException, InterruptedException
	{
	    final URI uri = new URI("https://www.oracle.com/index.html");
	
	    final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
	    final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();

	    final HttpClient httpClient = HttpClient.newHttpClient();
	    final HttpResponse<String> response = httpClient.send(request, asString);
	
        printResponseInfo(response);
	}
	
	private static void printResponseInfo(final HttpResponse<String> response)
	{
	    final int responseCode = response.statusCode();
	    final String responseBody = response.body();
	    final HttpHeaders headers = response.headers();
	    
	    System.out.println("Status:  " + responseCode);
	    System.out.println("Body:    " + responseBody);
	    System.out.println("Headers: " + headers.map());
	}
}