/*++++++++++++++++++++++++++++++++++++***************************
Quelle: javaDoc
****************************************************************/


package sk.train.gather;

import java.util.List;
import java.util.Optional;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class SuppliedGathererSamples {

	public static void main(String[] args) {

		windowFixed();
		windowSliding();
		fold();
		scan();
		mapConcurrent();
	}

	
	private static void windowFixed() {
		// will contain: [[1, 2, 3], [4, 5, 6], [7, 8]]
		List<List<Integer>> windows =
		    Stream.of(1,2,3,4,5,6,7,8)
		    .gather(Gatherers.windowFixed(3))
		    .toList();
		    
		windows.forEach(System.out::println);
		
		
	}
	
	private static void windowSliding() {
		// will contain: [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [7, 8]]
		List<List<Integer>> windows2 =
		    Stream.of(1,2,3,4,5,6,7,8)
		    .gather(Gatherers.windowSliding(2))
		    .toList();
		
		windows2.forEach(System.out::println);
	}
	
	private static void fold() {
		// will contain: Optional["123456789"]
		Optional<String> numberString =
		    Stream.of(1,2,3,4,5,6,7,8,9)
		          .gather(
		              Gatherers.fold(() -> "", (string, number) -> string + number)
		           )
		          .findFirst();
		
		System.out.println(numberString);
	}
	
	private static void scan() {
		// will contain: ["1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789"]
		List<String> numberStrings =
		    Stream.of(1,2,3,4,5,6,7,8,9)
		          .gather(
		              Gatherers.scan(() -> "", (string, number) -> string + number)
		           )
		          .toList();
		
		numberStrings.forEach(System.out::println);
	}
	
	private static void mapConcurrent() {
		Stream.of(1, 2, 3, 4, 5)
		.gather(Gatherers.mapConcurrent(4, i -> i * 2))
		.forEach(System.out::println);
	}

}
