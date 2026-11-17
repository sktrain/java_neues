package ch05_api.stream;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class MapMultiExample2
{

    public static void main(String[] args)
    {

        // OLD
        var stream = Stream.of(List.of(1, 2, 3), "ABC", null, Set.of("X", "Y", "Z"));

        Stream<Object> expandedStream = stream.flatMap(e -> {
            if (e instanceof Iterable<?> iterable)
            {
                // Trick to convert Iterable to Stream
                return StreamSupport.stream(iterable.spliterator(), false);
            }
            return Stream.of(e);
        });

        System.out.println(expandedStream.toList());

        // NEW
        var stream2 = Stream.of(List.of(1, 2, 3), "ABC", null, Set.of("X", "Y", "Z"));
        Stream<Object> expandedStream2 = stream2.mapMulti(MapMultiExample2::expandIterable);
        System.out.println(expandedStream2.toList());
    }

    static void expandIterable(Object e, Consumer<Object> c)
    {
        if (e instanceof Iterable<?> iterable)
        {
            for (Object elem : iterable)
            {
                expandIterable(elem, c);
            }
        }
        else
        {
            c.accept(e);
        }
    }
}
