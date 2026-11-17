package sk.train.apiupdate.java11;

import java.util.Objects;

/**
 * Erweiterung der Klasse Objects
 * 
 */

public class ObjectsNonNullSample {
	
	public static void main(final String[] args) {
		
		//Java 9
		
		String message = Objects.requireNonNullElse(null, "Default-Msg");
		
		String parameter = Objects.requireNonNullElseGet(null, () -> "No Param");
		
		System.out.println(message + " : " + parameter);
	}

}
