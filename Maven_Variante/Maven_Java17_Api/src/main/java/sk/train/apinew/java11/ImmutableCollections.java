package sk.train.apinew.java11;

import static java.util.Map.entry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/** Immutable Collections (Collection Literale) (ab Java 9)
 * 
 * Optimierte Datenstrukturen statt der bisherigen Wrapper.
 * Bei der Erzeugung werden die Inhalte festgelegt und sind dann unveränderbar.
 * Für Elementanzahl von 0 ... 9 überladene Factory-Methoden + varargs-Variante.
 * 
 * Ab Java 10: copyOf-Methode zur Übernahme der Werte aus vorhandener Collection
 *
 */

public class ImmutableCollections
{
    public static void main(final String[] args)
    {
        // Collection Literal Instantiierung (Java 9)
        List<String> names = List.of("String1", "String2", "String3");
        System.out.println(names.getClass());
        names.forEach(System.out::println);	//List ist geordnet
      
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);  //varargs-Variante
        System.out.println(numbers.getClass());
        numbers.forEach(System.out::println);

        Map<Integer, String> mapping = Map.of(5, "five", 6, "six");
        Map<Integer, String> mapping2 = Map.ofEntries(entry(5, "five"), 
                                                            entry(6, "six"));
        System.out.println(mapping2.getClass());
        mapping.forEach((key, value) -> System.out.println(key + ":" + value));
        mapping2.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println(mapping2.equals(mapping));
        
        
        // Collection Literal Instantiierung (Java 10)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        //list ist in diesem Fall schon immutable
        //list.add(0);
        List<Integer> listImmutable = List.copyOf(list);  
        listImmutable.forEach(System.out::println);
        
        Map<Integer, String> mapping3 = Map.copyOf(mapping2);
        mapping3.forEach((key, value) -> System.out.println(key + ":" + value));
        
        
        //Sets machen Duplikatsprüfung
        try {
			Set<Integer> numbersDuplicates = Set.of(1, 2, 3, 1);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}  
        
        
        //es gibt keine speziellen Varianten, z.B. TreeSet
        TreeSet<Integer> numbersSorted = new TreeSet<>(Set.of(1, 7, 3, 2));
        boolean erg = numbersSorted.add(5);
        System.out.println(erg);
        numbersSorted.forEach(System.out::println);
        
    }
}
