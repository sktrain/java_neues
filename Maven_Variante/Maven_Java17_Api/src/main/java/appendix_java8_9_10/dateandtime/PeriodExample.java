package appendix_java8_9_10.dateandtime;

import java.time.Period;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class PeriodExample 
{
	public static void main(final String[] args) 
	{
		// Erzeuge ein Period-Objekt mit 1 Jahr, 6 Monaten und 3 Tagen 
		final Period oneYear_sixMonths_ThreeDays = Period.ofYears(1).withMonths(6).
		                                                             withDays(3);

		// Chaining von of() arbeitet anders, als man es eventuell erwartet!  
		// Hier ein Period-Objekt mit 3 Tagen statt 2 Monate, 1 Woche und 3 Tagen  
		final Period twoMonths_OneWeek_ThreeDays = Period.ofMonths(2).ofWeeks(1).
		                                                              ofDays(3);
	
		final Period twoMonths_TenDays = Period.ofMonths(2).withDays(10);		
		final Period sevenWeeks = Period.ofWeeks(7);
		final Period threeDays = Period.ofDays(3);

		System.out.println("1 year 6 months ...:  " + oneYear_sixMonths_ThreeDays);
		System.out.println("Surprise just 3 days: " + twoMonths_OneWeek_ThreeDays);
		System.out.println("2 months 10 days:     " + twoMonths_TenDays);
		System.out.println("sevenWeeks:           " + sevenWeeks);
		System.out.println("threeDays:            " + threeDays);
	}
}          