package ch05_api.date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class DatePeriodExample
{
    public static void main(final String[] args)
    {
        printDayPeriodsByHour(Locale.US);
        System.out.println("===============================");
        printDayPeriodsByHour(Locale.GERMANY);
    }

    public static void printDayPeriodsByHour(final Locale locale)
    {
        var dateTimeFormat = DateTimeFormatter.ofPattern("hh B", locale);
        for (int hour = 0; hour < 24; hour++)
        {
            var localTime = LocalTime.now().withHour(hour);
            var formattedTime = dateTimeFormat.format(localTime);
            System.out.println("Stunde " + hour + ": '" + formattedTime + "'");
        }
    }
}
