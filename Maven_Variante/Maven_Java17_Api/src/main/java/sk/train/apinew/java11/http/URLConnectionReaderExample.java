package sk.train.apinew.java11.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Beispielprogramm für das Buch "Java – die Neuerungen in Version 9 bis 12"
 * 
 * @author Michael Inden
 * 
 * Copyright 2019 by Michael Inden 
 */
public class URLConnectionReaderExample
{
    public static void main(final String[] args) throws IOException
    {
        final URL oracleUrl = new URL("https://www.oracle.com/index.html");
        final URLConnection connection = oracleUrl.openConnection();

        final String content = readContent(connection.getInputStream());
        System.out.println(content);
    }

    public static String readContent(final InputStream is) throws IOException
    {
        try (final InputStreamReader isr = new InputStreamReader(is); final BufferedReader br = new BufferedReader(isr))
        {
            final StringBuilder content = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null)
            {
                content.append(line + "\n");
            }

            return content.toString();
        }
    }
}
