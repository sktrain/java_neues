package ch05_api.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class FilesReadWriteExample
{
    public static void main(final String[] args) throws IOException
    {
        Path destinationPath = Path.of("example-file.txt");
        
        readWriteV1(destinationPath);
        readWriteV2(destinationPath);
        readWriteV3(destinationPath);
    }

    private static void readWriteV1(Path destinationPath) throws IOException
    {
        Files.writeString(destinationPath, "1: This is a 'string to file' test\n");
        Files.writeString(destinationPath, "2: Second line");
        
        final String line1 = Files.readString(destinationPath);
        final String line2 = Files.readString(destinationPath);
        
        System.out.println(line1);
        System.out.println(line2);
    }
    
    private static void readWriteV2(Path destinationPath) throws IOException
    {
        Files.writeString(destinationPath, "1: This is a 'string to file' test\n");
        Files.writeString(destinationPath, "2: Second line", StandardOpenOption.APPEND);
                                    
        final String line1 = Files.readString(destinationPath);
        final String line2 = Files.readString(destinationPath);
        System.out.println(line1);
        System.out.println(line2);
    }
    
    private static void readWriteV3(Path destinationPath) throws IOException
    {
        Files.writeString(destinationPath, "1: This is a 'string to file' test\n");
        Files.writeString(destinationPath, "2: Second line", StandardOpenOption.APPEND);
                                    
        String content = Files.readString(destinationPath);
        content.lines().forEach(System.out::println);
    }
}
