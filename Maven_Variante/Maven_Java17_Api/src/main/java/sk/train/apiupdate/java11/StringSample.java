package sk.train.apiupdate.java11;

import java.util.stream.Stream;

/** Erweiterungen der Klasse String in Java 11
 * 
 */


public class StringSample {

	public static void main(String[] args) 
	{
		//boolean java.lang.String.isBlank()		
		String exampleText1 = "";
		String exampleText2 = "    ";		
		String exampleText3 = " \t \t ";		
		System.out.println(exampleText1.isBlank());
		System.out.println(exampleText2.isBlank());
		System.out.println(exampleText3.isBlank());
		
		//Stream<String> java.lang.String.lines()
		String exampleText = "1 This is a\n2 multi line\n3 text with\n4 four lines!";		
		Stream<String> lines = exampleText.lines();
		lines.forEach(System.out::println);
		
		//String java.lang.String.repeat(int count)
		String star = "*";		
		System.out.println(star.repeat(30));
		String delimeter = " -*- ";		
		System.out.println(delimeter.repeat(6));
		
		//strip(), stripLeading(), stripTrailing()
		String exampleText11 = "  abc ";
		String exampleText21 = " \t XYZ \t ";		
		System.out.println("trim():  '" + exampleText11.trim()+ "'");
		System.out.println("trim():  '" + exampleText21.trim()+ "'");
		System.out.println("strip(): '" + exampleText11.strip()+ "'");
		System.out.println("strip(): '"  + exampleText21.strip()+ "'");
		System.out.println("sL()     '" + exampleText21.stripLeading()+ "'");
		System.out.println("sT()     '" + exampleText21.stripTrailing() + "'");
	}

}
