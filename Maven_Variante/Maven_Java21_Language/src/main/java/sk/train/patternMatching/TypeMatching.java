package sk.train.patternMatching;

import java.time.LocalDate;

public class TypeMatching {

	public static void main(String[] args) {

		whatis(1);
		whatis("Hallo");
		whatis(LocalDate.now());
		
		System.out.println(formatterPatternSwitch(1));
		System.out.println(formatterPatternSwitch(1L));
		System.out.println(formatterPatternSwitch("Huhu"));
		System.out.println(formatterPatternSwitch(LocalDate.now()));

	}
	
	
	// As of Java 21 (switch expression)
	static String formatterPatternSwitch(Object o) {
	    return switch (o) {
	        case Integer i -> String.format("int %d", i);
	        case Long l    -> String.format("long %d", l);
	        case Double d  -> String.format("double %f", d);
	        case String s  -> String.format("String %s", s);
	        default        -> o.toString();
	    };
	}
	
	// As of Java 21 (switch statement)
	static void whatis(Object o) {
	    switch (o) {
	        case Number n         -> System.out.println("Zahl");
	        case CharSequence  c  -> System.out.println("Zeichenkette");
	        // default               -> System.out.println("Was Anderes");
	        case Object other     -> System.out.println("Was Anderes");
	    };
	}

}
