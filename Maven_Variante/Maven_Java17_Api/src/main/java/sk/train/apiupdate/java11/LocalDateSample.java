package sk.train.apiupdate.java11;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

public class LocalDateSample {

	public static void main(String[] args) {

		//Java 9: datesUntil()
		
		LocalDate startday = LocalDate.of(1965, Month.AUGUST, 8);
		LocalDate christmas = LocalDate.of(1971, Month.DECEMBER, 24);

		System.out.println("Day-Stream");
		Stream<LocalDate> daysUntil = startday.datesUntil(christmas); // default: day
		daysUntil.skip(150).limit(8).forEach(System.out::println);

		System.out.println("\nMonth-Stream");
		Stream<LocalDate> monthsUntil = startday.datesUntil(christmas, Period.ofMonths(1));
		monthsUntil.limit(5).forEach(System.out::println);
		
		//Java 9: und ein paar weitere Methoden
	}

}
