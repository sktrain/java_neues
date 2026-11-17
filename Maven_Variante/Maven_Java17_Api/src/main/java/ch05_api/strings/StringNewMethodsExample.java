package ch05_api.strings;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class StringNewMethodsExample
{
    public static void main(String[] args)
    {
        linesExample();
        
        transformationOldStyle();
        transformationJdk12Style();
        
        System.out.println(":-(".repeat(Integer.MAX_VALUE));
    }

    private static void linesExample()
    {
        final String exampleText = "1 This is a\r\n2 multi line\r" + 
                                   "3 text with\n4 four lines!";
        
        final Stream<String> lines = exampleText.lines();
        lines.forEach(System.out::println);
    }

    private static void transformationOldStyle()
    {
        var text = "This is a Test";

        var upperCase = text.toUpperCase();
        var withoutTs = upperCase.replaceAll("T", "");
        var result = withoutTs.split(" ");

        System.out.println(Arrays.toString(result));
    }

    private static void transformationJdk12Style()
    {
        var text = "This is a Test";

        // Hintereinanderschaltung von Operationen
        var result = text.transform(String::toUpperCase).transform(str -> str.replaceAll("T", ""))
                        .transform(str -> str.split(" "));

        System.out.println(Arrays.toString(result));
    }
}
