package ch05_api.stream;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
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
public class TeeingCollectorIntroExample
{
    public static void main(String[] args)
    {
        var names = Stream.of("Michael", "Tim", "Tom", "Mike", "Bernd", "Carsten");
        
        final Predicate<String> startsWithMi = text -> text.startsWith("Mi");
        final Predicate<String> endsWithM = text -> text.endsWith("m");
        
        // $\mbox{\bfseries Wäre var hier nicht wünschenswert? => siehe Text }$
        final BiFunction<List<String>, List<String>, List<List<String>>> combineLists =
                        (list1, list2) -> List.of(list1, list2);
              
        var result = names.collect(teeing(filtering(startsWithMi, toList()),
                                          filtering(endsWithM, toList()),
                                          combineLists));
        System.out.println(result);
    }

}
