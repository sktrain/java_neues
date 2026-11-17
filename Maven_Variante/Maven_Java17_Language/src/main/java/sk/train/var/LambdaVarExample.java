package sk.train.var;

import java.util.function.Function;
import java.util.function.ToIntFunction;

@interface SomeAnnotation { }

public class LambdaVarExample 
{
	public static void main(final String[] args) 
	{	
		ToIntFunction<String> ftyped = (String s) -> s.length(); 
		ToIntFunction<String> fnottyped = s -> s.length();

		ToIntFunction<String> fwithvar = (var s) -> s.length();
					
		Function<String, String> trimmer = (@SomeAnnotation var str) -> str.trim();  //hätte auch mit Typ statt var funktioniert
		
		System.out.println(ftyped.applyAsInt("Hallo"));
		System.out.println(fnottyped.applyAsInt("Hallo"));
		System.out.println(fwithvar.applyAsInt("Hallo"));
		System.out.println(trimmer.apply("  Huhu "));
	}
}