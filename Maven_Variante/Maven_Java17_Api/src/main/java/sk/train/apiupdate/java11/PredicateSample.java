package sk.train.apiupdate.java11;

import java.util.function.Predicate;

/** Erweiterung des Interface Predicate in Java 11
 * 
 */

public class PredicateSample {

	public static void main(String[] args) {

		Predicate<String> isempty = String::isEmpty;
		
		//bis Java 10
		Predicate<String> isnotempty = isempty.negate();
		
		//Java 11
		isnotempty = Predicate.not(isempty);

	}

}
