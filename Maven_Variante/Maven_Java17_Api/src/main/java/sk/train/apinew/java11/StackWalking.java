package sk.train.apinew.java11;

import java.lang.StackWalker.StackFrame;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Auswertung des Stacks via StackWalker-Klasse
 * 
 */

public class StackWalking {

	public static void main(String[] args) {		
		first();
	}

	private static void first() {
		second();		
	}

	private static void second() {
		third();	
	}

	private static void third() {
//		examineStackJava8();
		examineStackJava9();
	}

	private static void examineStackJava8() {
		
		StackTraceElement elements[] = Thread.currentThread().getStackTrace();
		Arrays.stream(elements).forEach( 
				element -> { System.out.println("Datei: " + element.getFileName());
							 System.out.println("Klasse: " + element.getClassName());
							 System.out.println("Methode: " + element.getMethodName());
							 System.out.println("Zeile: " + element.getLineNumber());
				           }
				);		
	}
	
	private static void examineStackJava9() {
		
		System.out.println("\n*************** StackWalking mit Java 9 ******************\n");
		StackWalker sw = StackWalker.getInstance();  //hier sind Optionen m�glich bzgl. Infos
		sw.forEach(element -> { System.out.println("Datei: " + element.getFileName());
							 System.out.println("Klasse: " + element.getClassName());
							 System.out.println("Methode: " + element.getMethodName());
							 System.out.println("Zeile: " + element.getLineNumber());
				           });
		
		//bzw. mit walk-Methode: stellt StackFrames als Stream zur Verf�gung und 
		//erwartet Function, die den Stream verarbeitet
		System.out.println("\n*************** StackWalking mittels walk() ******************\n");
		Function<Stream<StackFrame>, Map<Integer, List<StackFrame>>> walkFunction = 
			    ( stream -> stream
						   .filter(frame -> frame.getLineNumber() <= 22)
						   .collect(Collectors.groupingBy(frame -> frame.getLineNumber())));
		Map<Integer, List<StackFrame>> framemap =sw.walk(walkFunction);
		System.out.println(framemap);
	} 

}
