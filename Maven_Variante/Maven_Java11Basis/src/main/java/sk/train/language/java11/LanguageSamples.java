package sk.train.language.java11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LanguageSamples {
	
	public static void main(String[] args) {

		// var statt Typangabe bei lokalen Variablen (ab Java 10)
		var name = "Stephan";	// Compiler leitet Typ String ab
		
		//Map<String, Integer>
		var map = Map.of("Max", 1, "Karl", 5 , "Otto", 2);		//Java 9: Map.of
		
		//Map<String, List<Entry<String, Integer>>>
		var result = map.entrySet().stream()
					 .collect(Collectors.groupingBy(Entry::getKey));
		
		//hier ist Cast nötig!
		var isshort =(Predicate<String>)s -> s.length()<2;  //Compiler muss Typ ableiten!!
		
		Object o = (Predicate<String>) s -> s.length()<2;
		
		//Vorsicht
		var al = new ArrayList<> ();  //Diamond-Operator: ArrayList<Object>
		al.add(new Object());   //Typ-Parameter ist Object!!
		List l = al;
		//LinkedList ll = l;	//Compiler-Fehler!! : l referenziert ArrayList
		
		//ab Java 11: var bei Lambda-Parametern
		UnaryOperator<String> uops = (var s) -> s.toLowerCase();
	
	}
}
