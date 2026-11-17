package ch05_api.stream;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class TeeingCollectorExample
{
    public static void main(final String[] args)
    {
        System.out.println(calcCountAndSum(Stream.of(1, 2, 3, 4, 5, 6)));

        System.out.println(calcCountAndSum(Stream.of(2, 3, 5, 7, 11, 13, 17)));
    }

    private static LongPair calcCountAndSum(Stream<Integer> numbers)
    {
        return numbers.collect(teeing(counting(), 
                                      summingLong(n -> n), 
                                      (count, sum) -> new LongPair(count, sum)));
    }

    static record LongPair(long count, long sum)
    {
    }
}
