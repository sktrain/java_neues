package appendix_java8_9_10.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SortedAndDistinctExample
{
    public static void main(final String[] args)
    {
        final Stream<Integer> distinct = createIntStream().distinct();
        final Stream<Integer> sorted = createIntStream().sorted();
        final Stream<Integer> sortedAndDistinct = createIntStream().sorted().distinct();

        printResult("distinct:          ", distinct);
        printResult("sorted:            ", sorted);
        printResult("sortedAndDistinct: ", sortedAndDistinct);
    }

    private static Stream<Integer> createIntStream()
    {
        return Stream.of(7, 1, 4, 3, 7, 2, 6, 5, 7, 9, 8);
    }

    private static void printResult(final String hint, final Stream<Integer> stream)
    {
        final List<Integer> result = stream.collect(Collectors.toList());
        System.out.println(hint + result);
    }
}