package ch05_api.strings;

import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class StringNewJava11MethodsExample
{
    public static void main(String[] args)
    {
        isBlankExample();
//        specialSpaces();
//        linesExample();
//
        System.out.println(":-(".repeat(20));
    }

    private static void isBlankExample() 
    {
        final String exampleText1 = "";
        final String exampleText2 = "    ";     
        final String exampleText3 = " \n \t ";      
            
        System.out.println(exampleText1.isBlank());
        System.out.println(exampleText2.isBlank());
        System.out.println(exampleText3.isBlank());
    }

    private static void specialSpaces()
    {
        String specialSpaces = "   "; // "\u00a0\u00a0\u00a0";
        System.out.println("'" + specialSpaces + "'");
        
        System.out.println(specialSpaces.trim().isEmpty());
        System.out.println("'" + specialSpaces.strip() + "'");
        System.out.println(specialSpaces.strip().isEmpty());
        System.out.println(specialSpaces.isBlank());
    }    
    
    private static void linesExample()
    {
        final String exampleText = "1 This is a\r\n2 multi line\r" + 
                                   "3 text with\n4 four lines!";
        
        final Stream<String> lines = exampleText.lines();
        lines.forEach(System.out::println);
    }
}
