package sk.train.var;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class VarExample {

	public static void main(String[] args) {
		
		var name = "Stephan Karrer";
		var list = new ArrayList<ArrayList<String>>();
		//var x = null;  //unzulässig
		var var = 77;  //zulässig: var ist nur als Typ-Ersatz Schlüsselwort!
		
		//System.out.println(var.getClass());
		
		var personAgeMapping = Map.of("Tim", 47L, "Tom", 12L, "Mike", 47L, "Max", 25L);
		//Cast ist notwendig
		Object o = (Predicate<Map.Entry<String, Long>>) entry -> entry.getValue() >= 18;
		// o = entry -> entry.getValue() >= 18;
		var isAdult = (Predicate<Map.Entry<String, Long>>) entry -> entry.getValue() >= 18;
		var firstChar = (Function<Map.Entry<String, Long>, Character>) entry -> entry.getKey().charAt(0);
		//hier ist alles klar für den Compiler
		var filteredPersons = personAgeMapping.entrySet().stream().
                collect(groupingBy(firstChar, 
                        filtering(isAdult, toSet())));	
		
		//Fallstricke
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) { }  //unzulässig: var e 
		
		var counter = 9_999_999_999_999L;  //muss long sein
		//hier hilft auch Cast nicht:  counter = (long)  9_999_999_999_999;
		var b = (byte) 1+1;   //Typ ist byte
		
		var intarray = new int[]{1, 2, 3};  //Unzulässig: var intarray = {1, 2, 3}
		
		var query = new StringBuilder("string1");
		//unzulässig:    query = query.toString() + "string2";
		
		var l = new ArrayList<>();
		l.add(1); l.add("Hallo");	//keine Typsicherheit mehr
		
		
		
		var li = List.of(1, 3, 4);
		List<Integer> lInteger = li;
		
		var what = List.of(1, "2", LocalTime.now());  //was ist der Typ?
		System.out.println(List.of(1, "2", LocalTime.now()).getClass());
		//unzulässig: List<Object> lo = what;
		
		var what1 = List.of(Integer.valueOf(1), "2", LocalTime.now());
		//unzulässig: Inhaltstyp ist polymorph
		//List<Object> lo = what1;
		System.out.println(what1 instanceof List);
		
		for (var value: what) {
			System.out.println(value.getClass());
		}
		
		var function = new Function<String, Integer>() { 
			@Override public Integer apply(String s) { return s.length(); } 
			};
		System.out.println(function.getClass());
		
		// illegal: Zuweisung eines Objekts einer neuen anonymen Klasse!
		//function = new Function<String, Integer>() { @Override public Integer apply(String s) { return s.length(); } };
		
			
	}
}
