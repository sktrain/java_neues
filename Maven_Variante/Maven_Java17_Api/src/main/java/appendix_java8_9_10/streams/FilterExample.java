package appendix_java8_9_10.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class FilterExample
{
    public static void main(final String[] args)
    {
        final List<Person> persons = new ArrayList<>();

        persons.add(new Person("Micha", 43, "Zürich"));
        persons.add(new Person("Barbara", 40, Gender.FEMALE, "Hamburg"));
        persons.add(new Person("Yannis", 5, "Hamburg"));

        // final Predicate<Person> isAdult = person -> person.getAge() >= 18;
        final Stream<Person> adults = persons.stream().filter(Person::isAdult);

        adults.forEach(System.out::println);
    }
}