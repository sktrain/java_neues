package ch05_api.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class FilesMismatchExample
{
    public static void main(final String[] args) throws IOException
    {
        compareSameContent();
        compareDifferentContent();
        
        compareDifferentEncodings();
    }
    
    private static void compareSameContent() throws IOException 
    {
    	var filePath1 = Files.createTempFile("test1", ".txt");
    	var filePath2 = Files.createTempFile("test2", ".txt");
        
        Files.writeString(filePath1, "Same Content");
        Files.writeString(filePath2, "Same Content");
    
        var pos = Files.mismatch(filePath1, filePath2);
        System.out.println("Same content: mismatch(File1, File2) = " + pos);  
    }
    
    private static void compareDifferentContent() throws IOException 
    {
        var filePath1 = Files.createTempFile("test1", ".txt");
        var filePath2 = Files.createTempFile("test2", ".txt");
        
        Files.writeString(filePath1, "Same Content");
        Files.writeString(filePath2, "Same Start / Different Content");
        
        var pos = Files.mismatch(filePath1, filePath2);
        System.out.println("Different content: mismatch(File1, File2) = " + pos);
    } 
    
    private static void compareDifferentEncodings() throws IOException 
    {
        var fileLatin = Files.createTempFile("enc1", ".latin");
        var fileUtf8 = Files.createTempFile("enc2", ".utf8");
            
        var msg = "Zürich is beautiful. Mainz too";
        Files.writeString(fileLatin, msg, StandardCharsets.ISO_8859_1);
        Files.writeString(fileUtf8, msg, StandardCharsets.UTF_8);

        var pos = Files.mismatch(fileLatin, fileUtf8);
        System.out.println("Different encoding: mismatch(fileLatin, fileUtf8)" + 
                           " = " + pos);
    }
}

