package appendix_java8_9_10.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
public class CompletableFutureExample
{
    public static void main(final String[] args) throws IOException, InterruptedException, ExecutionException
    {
        final Path exampleFile = Paths.get("src/main/resources/Example.txt");

        // Moeglicherweise laengerdauernde Aktion
        final CompletableFuture<List<String>> contents = CompletableFuture
                        .supplyAsync(extractWordsFromFile(exampleFile));
        contents.thenAccept(text -> System.out.println("Initial: " + text));

        // Filterungen parallel ausfuehren
        final CompletableFuture<List<String>> filtered1 = contents.thenApplyAsync(removeIgnorableWords());
        final CompletableFuture<List<String>> filtered2 = contents.thenApplyAsync(removeShortWords());

        // Verbinde die Ergebnisse
        final CompletableFuture<List<String>> result = filtered1.thenCombine(filtered2, calcIntersection());

        // keine Ausgabe ohne diese Zeile!? => erst Terminal Operation stoesst Berechnung an
        System.out.println("result: " + result.get());
    }

    private static Supplier<List<String>> extractWordsFromFile(final Path exampleFile)
    {
        return () -> {
            try
            {
                final List<String> lines = Files.readAllLines(exampleFile);

                final Stream<String> words = lines.stream().flatMap(line -> Stream.of(line.split(" ")));

                final Function<String, String> removePunctationMarks = removePunctationMarks();

                final Stream<String> mapped = words.map(removePunctationMarks);
                final Stream<String> sorted = mapped.sorted(String.CASE_INSENSITIVE_ORDER);

                return sorted.collect(Collectors.toList());
            }
            catch (final Exception e)
            {
                return Collections.emptyList();
            }
        };
    }

    private static Function<String, String> removePunctationMarks()
    {
        final Function<String, String> removePunctationMarks = str -> {
            if (str.endsWith(".") || str.endsWith(":") || str.endsWith("!"))
            {
                return str.substring(0, str.length() - 1);
            }
            else
            {
                return str;
            }
        };
        return removePunctationMarks;
    }

    private static Function<List<String>, List<String>> removeIgnorableWords()
    {
        final List<String> ignoreableWords = Arrays.asList("this", "This", "line", "text");
        final Predicate<String> isIgnorableWord = word -> ignoreableWords.contains(word);

        return input -> {
            return input.stream().filter(isIgnorableWord.negate()).collect(Collectors.toList());
        };
    }

    private static Function<List<String>, List<String>> removeShortWords()
    {
        final Predicate<String> isShortWord = word -> word.length() <= 3;
        final Predicate<String> notIsShortWord = isShortWord.negate();

        return input -> {
            return input.stream().filter(notIsShortWord).collect(Collectors.toList());
        };
    }

    private static BiFunction<? super List<String>, ? super List<String>, ? extends List<String>> calcIntersection()
    {
        return (list1, list2) -> {
            list1.retainAll(list2);
            return list1;
        };
    }
}