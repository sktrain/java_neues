package appendix_java8_9_10.dateandtime;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.firstDayOfNextMonth;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class PredefinedTemporalAdjustersExample
{
    public static void main(final String[] args)
    {
        final LocalDate date = LocalDate.of(2022, Month.FEBRUARY, 7);

        final LocalDate firstOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        final LocalDate lastofMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        final LocalDate firstOfNextMonth = date.with(firstDayOfNextMonth());
        final LocalDate firstMondayInMonth = date.with(firstInMonth(DayOfWeek.MONDAY));
        final LocalDate lastSaturdayInMonth = date.with(lastInMonth(SATURDAY));

        System.out.println("date:                " + date);
        System.out.println("lastofMonth:         " + lastofMonth);
        System.out.println("firstOfMonth:        " + firstOfMonth);
        System.out.println("firstOfNextMonth:    " + firstOfNextMonth);
        System.out.println("firstMondayInMonth:  " + firstMondayInMonth);
        System.out.println("lastSaturdayInMonth: " + lastSaturdayInMonth);
    }
}
