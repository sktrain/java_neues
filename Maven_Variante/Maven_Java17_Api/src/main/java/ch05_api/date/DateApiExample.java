package ch05_api.date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class DateApiExample
{
    public static void main(String[] args)
    {
        var localTime = LocalTime.parse("15:25:08.690791");
        var formatter = DateTimeFormatter.ofPattern("h B");

        System.out.println(localTime.format(formatter));
    }
}
