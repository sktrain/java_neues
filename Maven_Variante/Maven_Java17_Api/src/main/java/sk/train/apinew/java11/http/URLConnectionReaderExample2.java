package sk.train.apinew.java11.http;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class URLConnectionReaderExample2
{
    public static void main(final String[] args) throws Exception
    {
        final URL oracle = new URL("https://www.oracle.com/index.html");
        final URLConnection connection = oracle.openConnection();

        System.out.println("Date           " + toDate(connection.getDate()));
        System.out.println("Last Modified  " + toDate(connection.getLastModified()));
        System.out.println("Content type   " + connection.getContentType());
        System.out.println("Content length " + connection.getContentLength());
    }

    public static String toDate(final long timeInMillis)
    {
        return new SimpleDateFormat().format(new Date(timeInMillis));
    }
}
