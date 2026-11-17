package sk.train.apiupdate.java11;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Erweiterungen der Klasse Optional in Java 9
 *
 */

public class OptionalSample {

	public static void main(String[] args) {

		/** Java 9	*/
		
		//ifPresentOrElse(Consumer<? super String> action, Runnable emptyAction)
		Optional<String> first = Stream.of("Hugo", "Otto", "Karl").filter(string -> string.length() < 3).findFirst();
		first.ifPresentOrElse(System.out::println, () -> System.out.println("kein Treffer"));
		
		
		//or(Supplier<? extends Optional<? extends String>> supplier)
		Optional<String> name = find1("Hugo")
				                .or(() -> find2("Hugo"))
				                .or(() -> find3("Hugo"));
		name.ifPresentOrElse(System.out::println, () -> System.out.println("kein Treffer"));
		
		//java.util.Optional.stream()
		Stream.of(Optional.of("Hugo"), Optional.of("Otto"),
                			  Optional.empty(), Optional.of("Karl"),
                			  Optional.empty(), Optional.of("Stefan"))
				          .flatMap(Optional::stream)
				          .forEach(System.out::println);
		
		/** Java 10	*/
		//neben get "orElseThrow"
		Optional<String> opt = Optional.empty();
		try {
			opt.orElseThrow(() -> new IllegalAccessException());  //Supplier für die Exception
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		}
		
		/** Java 11	*/
		//isEmpty()
		System.out.println(opt.isEmpty());
		
	}

	private static Optional<String> find1(String customerId) {
		Stream<String> customers = Stream.of("Max", "Karl", "Otto", "Andy");
		return customers.filter(name -> name.contains(customerId)).findFirst();
	}

	private static Optional<String> find2(final String customerId) {
		return Optional.empty();
	}

	private static Optional<String> find3(final String customerId) {
		System.out.println("findInDb");
		return Optional.empty();
	}

}
