package appendix_java8_9_10.dateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class DatesUntilExample
{
    public static void main(final String[] args)
    {
        final LocalDate myBirthday = LocalDate.of(1971, Month.FEBRUARY, 7);
        final LocalDate christmas = LocalDate.of(1971, Month.DECEMBER, 24);

        System.out.println("Day-Stream");
        final Stream<LocalDate> daysUntil = myBirthday.datesUntil(christmas);
        daysUntil.skip(150).limit(5).forEach(System.out::println);

        System.out.println("\nMonth-Stream");
        final Stream<LocalDate> monthsUntil = myBirthday.datesUntil(christmas, Period.ofMonths(1));
        monthsUntil.limit(3).forEach(System.out::println);
    }
}
