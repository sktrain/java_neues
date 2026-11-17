package ch05_api.compactnumberformat;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
public class CompactNumberFormatUnitsExample
{
    private static String[] createUnitPatterns()
    {
        final String[] unitPatterns = { "0 [B]", "00 [B]", "000 [B]",
                                        "0 [KB]", "00 [KB]", "000 [KB]",
                                        "0 [MB]", "00 [MB]", "000 [MB]",
                                        "0 [GB]", "00 [GB]", "000 [GB]",
                                        "0 [TB]", "00 [TB]", "000 [TB]" };
        return unitPatterns;
    }

    public static void main(final String[] args)
    {
        final String[] unitPatterns = createUnitPatterns();

        var decimalFormat =
            (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);

        var customCompactNumberFormat =
            new CompactNumberFormat(decimalFormat.toPattern(),
                                    decimalFormat.getDecimalFormatSymbols(),
                                    unitPatterns);
        customCompactNumberFormat.setMinimumFractionDigits(2);
        printNumbers(customCompactNumberFormat);
    }

    private static void printNumbers(NumberFormat numberFormat)
    {
        var numbers = List.of(990, 999, 1_499,1_500, 1_750, 1_999,
                        1_499_999, 1_500_000, 1_567_890);

        numbers.forEach(value -> System.out.println(numberFormat.format(value)));
    }
}
