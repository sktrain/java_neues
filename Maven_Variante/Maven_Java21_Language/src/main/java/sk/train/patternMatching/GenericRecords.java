package sk.train.patternMatching;


record GenericPoint<T>(T x, T y) {
}

public class GenericRecords {

	public static void main(String[] args) {
		GenericPoint<Integer> p1 = new GenericPoint<>(1, 1);
		GenericPoint<String> p2 = new GenericPoint<>("1", "1");
		printSumJava21(p1);
		printSumJava21(p2);
	}

	static void printSumJava21(Object obj) {
//		if (obj instanceof GenericPoint<Integer>(Integer x, Integer y)) {
//			System.out.println("GenericPoint<Integer>");
//		}
		if (obj instanceof GenericPoint(Integer x, Integer y)) {
			System.out.println("GenericPoint<Integer>");
			Integer z = x;
			System.out.println(x+y);
		}
		// if (obj instanceof Point<Integer>(Integer x, Integer y))
		else {
			// p is not valid here
			// System.out.println(p.x);
			System.out.println("no match");
		}
	}

}
