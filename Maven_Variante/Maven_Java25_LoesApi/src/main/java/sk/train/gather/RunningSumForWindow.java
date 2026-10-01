package sk.train.gather;

import java.util.List;
import java.util.stream.Gatherers;

/*
 * Zerlegen Sie die Ausgangsliste in fixe Fenster der Größe 3 und 
 * erstellen Sie je Fenster die laufende Summe der Werte
 */

public class RunningSumForWindow {

	public static void main(String[] args) {

		List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		var result = ints.stream()
				.gather(Gatherers.windowSliding(3))
				.map(window ->
		        		window.stream().gather(Gatherers.scan(() -> 0, Integer::sum))
		        		.toList())
		    .toList();

		IO.println("result = " + result);
	}

}
