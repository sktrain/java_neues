package ch05_api.date;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class DurationIntroExample 
{
	public static void main(String[] args) 
	{
		System.out.println(Duration.of(20L, ChronoUnit.DAYS).isNegative());
		System.out.println(Duration.of(-12L, ChronoUnit.DAYS).isNegative());
	}
}