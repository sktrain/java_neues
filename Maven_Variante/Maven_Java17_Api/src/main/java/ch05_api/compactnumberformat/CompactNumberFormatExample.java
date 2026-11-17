package ch05_api.compactnumberformat;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.util.Locale;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class CompactNumberFormatExample 
{
	public static void main(String[] args) throws ParseException
	{
	    compactNumberFormatUS();
	    compactNumberFormatDE();
	}

    private static void compactNumberFormatUS() throws ParseException
    {
        System.out.println("US/SHORT parsing:");
	
	    var shortFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
	    System.out.println(shortFormat.parse("1 K")); // ACHTUNG
	    System.out.println(shortFormat.parse("1K"));
	    System.out.println(shortFormat.parse("1M"));
	    System.out.println(shortFormat.parse("1B"));

	    System.out.println("\nUS/LONG parsing:");
	
	    var longFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
	    System.out.println(longFormat.parse("1 thousand"));
	    System.out.println(longFormat.parse("1 million"));
	    System.out.println(longFormat.parse("1 billion"));
    }
    
    private static void compactNumberFormatDE() throws ParseException
    {
        System.out.println("DE/SHORT parsing:");
    
        var shortFormat = NumberFormat.getCompactNumberInstance(Locale.GERMANY, Style.SHORT);
        System.out.println(shortFormat.parse("1000"));
        System.out.println(shortFormat.parse("1\u00a0Mio."));
        System.out.println(shortFormat.parse("1 Mrd."));
        System.out.println(shortFormat.parse("1\u00a0Mrd."));
    
        System.out.println("\nDE/LONG parsing:");
    
        var longFormat = NumberFormat.getCompactNumberInstance(Locale.GERMANY, Style.LONG);
        System.out.println(longFormat.parse("1 Tausend"));
        System.out.println(longFormat.parse("1 Million"));
        System.out.println(longFormat.parse("1 Milliarde"));
    }
}

