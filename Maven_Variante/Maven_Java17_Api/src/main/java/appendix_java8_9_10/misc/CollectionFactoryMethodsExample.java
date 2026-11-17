package appendix_java8_9_10.misc;

import static java.util.Map.entry;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class CollectionFactoryMethodsExample
{
    public static void main(final String[] args)
    {
        // Collection Literals
        final List<String> names = List.of("MAX", "MORITZ", "MIKE");
        names.forEach(name -> System.out.println(name));
      
        final Set<Integer> numbers = Set.of(1, 2, 3);
        numbers.forEach(number -> System.out.println(number));

        final Map<Integer, String> mapping = Map.of(5, "five", 6, "six");
        final Map<Integer, String> mapping2 = Map.ofEntries(entry(5, "five"), 
                                                            entry(6, "six"));

        mapping.forEach((key, value) -> System.out.println(key + ":" + value));
        mapping2.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
