package sk.train.apiupdate.java11;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.stream.Collectors.toUnmodifiableSet;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** Erweiterungen im Stream-API
 * 
 */

public class StreamSample {
	
	public static void main(String[] args)
    {
		//Java 9: dropWhile() und takeWhile()
        Stream<String> words = Stream.of("ab", "bla", "<START>", 
                                         "Hier", "steht", "der", "Text",
                                         "zwischen", "den", "Start- ",
                                         "und", "Ende-Begrenzern",
                                         "<END>", "saas", "bla");
        Stream<String> content = words.dropWhile(word -> !word.equals("<START>"))
                                      .skip(1)
                                      .takeWhile(word -> !word.equals("<END>"));
        content.forEach(System.out::println);  
        
        //Java 9: Iterate mit Abbruch-Bedingung
        IntStream stream = IntStream.iterate(1, n -> n < 5, n -> n + 1);
        stream.forEach(System.out::println);
        
        //Java 9: ofNullable()
        
        
        
        //Java 10: Immutable Collections als Collectoren
		var names = List.of("Tim", "Tom", "Mike", "Peter", "Tom", "Tim");

		var immutableNames = names.stream().collect(toUnmodifiableList());
		System.out.println("immutableNames type: " + immutableNames.getClass());

		var uniqueImmutableNames = names.stream().collect(toUnmodifiableSet());
		System.out.println("uniqueImmutableNames content: " + uniqueImmutableNames);
		System.out.println("uniqueImmutableNames type: " + uniqueImmutableNames.getClass());

		var nameCount = names.stream().collect(toUnmodifiableMap(key -> key, value -> 1L, (count, inc) -> count + inc));
		System.out.println("content: " + nameCount);
		System.out.println("type:    " + nameCount.getClass());        
        
    }

}
