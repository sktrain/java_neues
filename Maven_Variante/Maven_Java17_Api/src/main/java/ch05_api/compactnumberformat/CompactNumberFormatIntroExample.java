package ch05_api.compactnumberformat;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class CompactNumberFormatIntroExample
{

    public static void main(final String args[])
    {
        var shortFormat = getUsCompactNumberFormat(NumberFormat.Style.SHORT);
        formatNumbers("SHORT", shortFormat);

        var longFormat = getUsCompactNumberFormat(NumberFormat.Style.LONG);
        formatNumbers("LONG", longFormat);
    }

    private static NumberFormat getUsCompactNumberFormat(NumberFormat.Style style)
    {
        return NumberFormat.getCompactNumberInstance(Locale.US, style);
    }

    private static void formatNumbers(final String style, final NumberFormat numberFormat)
    {
        System.out.println("\nNumberFormat " + style);
        System.out.println("Result: " + numberFormat.format(10_000));
        System.out.println("Result: " + numberFormat.format(123_456));
        System.out.println("Result: " + numberFormat.format(1_234_567));
        System.out.println("Result: " + numberFormat.format(1_950_000_000));
    }

}
