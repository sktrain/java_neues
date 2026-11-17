package sk.train.kleinigkeiten;

public class IntegerConsructorDeprecation {

	public static void main(String[] args) {

		Integer I = new Integer(4711);
		I = Integer.valueOf(4711);
		
		I = 4711; Integer J = 4711;
		Integer I2 = 1; Integer J2 = 1;
		
		System.out.println(I == J);
		System.out.println(I2 == J2);

	}

}
