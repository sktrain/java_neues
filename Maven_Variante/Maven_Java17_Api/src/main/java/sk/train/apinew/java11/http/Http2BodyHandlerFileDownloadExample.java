package sk.train.apinew.java11.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class Http2BodyHandlerFileDownloadExample
{
	public static void main(final String[] args) throws Exception
	{
	    final URI uri = new URI("https://hzd.hessen.de/");
	    
	    final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
	
	    final Path downloadPath = Paths.get("oracle-index.html");
	    final BodyHandler<Path> asFile = HttpResponse.BodyHandlers.ofFile(downloadPath);
	
	    final HttpClient httpClient = HttpClient.newHttpClient();
	    final HttpResponse<Path> response = httpClient.send(request, asFile);
	    
	    if (response.statusCode() == 200)
	    {
	        System.out.println("Content written to file: " + downloadPath.toAbsolutePath());
	        
			System.out.println(response.statusCode());
			System.out.println(response.body());
	    }
	    
	    Thread.sleep(1000);
	}
}