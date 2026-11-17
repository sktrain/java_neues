package ch05_api.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
// nahezu analog zu Java Doc
public class MapMultiExample1
{
    public static void main(String[] args)
    {
        // OLD
        Stream.of(Optional.of("0"), Optional.empty(), Optional.of("1"), Optional.empty(), Optional.of("2"),
                  Optional.empty(), Optional.of("3")).flatMap(Optional::stream).forEach(System.out::print);

        // NEW
        Stream.of(Optional.of("0"), Optional.empty(), Optional.of("1"), Optional.empty(), Optional.of("2"),
                  Optional.empty(), Optional.of("3")).mapMulti(Optional::ifPresent). // !!!
                        forEach(System.out::print);

        // Mehr der Gedanke wie
        var elements = List.of(Optional.of("0"), Optional.empty(), Optional.of("1"), Optional.empty(), Optional.of("2"),
                               Optional.empty(), Optional.of("3"));
        for (Optional optElem : elements)
        {
            optElem.ifPresent(System.out::print);
        }

        // --------------------------------------------------------------

        System.out.println();
        System.out.println("Special");
        Stream.of(Optional.of("0"), Optional.empty(), Optional.of("1"), Optional.empty(), Optional.of("2"),
                  Optional.empty(), Optional.of("3")).mapMulti(MapMultiExample1::just23).forEach(System.out::print);

        /*
        Stream.of(Optional.of("0"), Optional.empty(), Optional.of("1"), 
        		  Optional.empty(), Optional.of("2"), Optional.empty(), Optional.of("3") ).
               mapMulti(MapMultiExample1::just23_2).
        	   forEach(System.out::print);
        */

        Stream<Optional<String>> optVals = Stream.of(Optional.of("0"), Optional.empty(), Optional.of("1"),
                                                     Optional.empty(), Optional.of("2"), Optional.empty(),
                                                     Optional.of("3"));
        Stream<String> vals = optVals.mapMulti(MapMultiExample1::just23_2);

        vals.forEach(System.out::print);

        /*
        for (Optional optElem : List.of(Optional.of("0"), Optional.empty(), Optional.of("1"), 
        		  Optional.empty(), Optional.of("2"), Optional.empty(), Optional.of("3")) )
        {
        	optElem.ifPresent(System.out::print);
        }
        */
    }

    static void just23(Object obj, Consumer<Object> consumer)
    {
        if (obj instanceof Optional optElem && optElem.isPresent() && "23".contains((String) optElem.get()))
            consumer.accept(optElem.get());
    }

    // geht nicht direkt in Eclipe
    static void just23_2(Optional<String> optElem, Consumer<String> consumer)
    {
        if (optElem.isPresent() && "23".contains(optElem.get()))
            consumer.accept(optElem.get());
    }
}
