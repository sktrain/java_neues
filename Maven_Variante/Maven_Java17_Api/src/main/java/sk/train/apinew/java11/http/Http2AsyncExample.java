package sk.train.apinew.java11.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.concurrent.CompletableFuture;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class Http2AsyncExample
{
	public static void main(final String[] args) throws Exception
	{
	    final URI uri = new URI("https://hzd.hessen.de/");
	
	    final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
	    final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
	
	    final HttpClient httpClient = HttpClient.newHttpClient();
	    final CompletableFuture<HttpResponse<String>> asyncResponse = httpClient.sendAsync(request, asString);
	    asyncResponse.thenRun(() -> System.out.println("Fertig"));//thenAccept(response -> printResponseInfo(response));
	    Thread.sleep(1000);
	
//	    waitForCompletion();
//	    if (asyncResponse.isDone())
//	    {
//	        final HttpResponse<String> response = asyncResponse.get();
//	        printResponseInfo(response);
//	    }
//	    else
//	    {
//	        asyncResponse.cancel(true);
//	        System.err.println("timeout");
//	    }
	}
	
	private static void waitForCompletion() throws InterruptedException
	{
	    for (int i = 0; i < 10; i++)
	    {
	        System.out.println("Step " + i);
	        Thread.sleep(200);
	    }
	}
	
	private static void printResponseInfo(final HttpResponse<String> response)
	{
	    final int responseCode = response.statusCode();
	    final String responseBody = response.body();
	
	    System.out.println("Status: " + responseCode);
	    System.out.println("Body:   " + responseBody);
	}
}