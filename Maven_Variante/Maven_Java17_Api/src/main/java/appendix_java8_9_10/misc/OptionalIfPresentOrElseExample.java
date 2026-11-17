package appendix_java8_9_10.misc;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class OptionalIfPresentOrElseExample
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer1 = findCustomer("Tim");
        optCustomer1.ifPresentOrElse(str -> System.out.println("found: " + str), () -> System.out.println("not found"));

        final Optional<String> optCustomer2 = findCustomer("UNKNWON");
        optCustomer2.ifPresentOrElse(str -> System.out.println("found: " + str), () -> System.out.println("not found"));
    }

    private static Optional<String> findCustomer(String customerId)
    {
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        if (customers.anyMatch(name -> name.contains(customerId)))
        {
            return Optional.of(customerId);
        }
        return Optional.empty();
    }
}
