// Quelle: Kollege Novak

package sk.train.kleinigkeiten;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Function;


public class DiamondOperatorViaReflection {

	public static void main(String[] args) {
		demoFunctionOld();
		demoFunctionNew();
	}
	
	static void demoFunctionOld() {
		final Function<String, Integer> func = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				printGenericType(this);
				return s.length();
			}
		};
		System.out.println(func.apply("Hello"));
	}

	static void demoFunctionNew() {
		final Function<String, Integer> func = new Function<>() {
			@Override
			public Integer apply(String s) {
				printGenericType(this);
				return s.length();
			}
		};
		System.out.println(func.apply("Hello"));
	}

	
	
	static void printGenericType(Object obj) {
		try {
			Class<?> cls = obj.getClass();
			ParameterizedType pt = (ParameterizedType) cls.getGenericInterfaces()[0];
			Type[] typeArgs = pt.getActualTypeArguments();
			System.out.print(cls.getInterfaces()[0].getSimpleName() + "<");
			for (int i = 0; i < typeArgs.length; i++) {
				if (i > 0)
					System.out.print(", ");
				System.out.print(((Class<?>)typeArgs[i]).getSimpleName());
			}
			System.out.println(">");
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

}
