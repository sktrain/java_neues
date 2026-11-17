package ch05_api.compactnumberformat;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.List;
import java.util.Locale;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class CompactNumberFormatRoundingExample
{
    public static void main(String[] args)
    {
        var shortFormat = NumberFormat.getCompactNumberInstance(Locale.US,
                                                                Style.SHORT);

        printNumbers(shortFormat);

        System.out.println("=== one fraction digit ===");
        shortFormat.setMinimumFractionDigits(1);
        printNumbers(shortFormat);

        System.out.println("=== two fraction digits ===");
        shortFormat.setMinimumFractionDigits(2);
        printNumbers(shortFormat);
    }

    private static void printNumbers(NumberFormat numberFormat)
    {
        var numbers = List.of(990, 999, 1_499,1_500, 1_750, 1_999,
                        1_499_999, 1_500_000, 1_567_890);

        numbers.forEach(value -> System.out.println(numberFormat.format(value)));
    }
}