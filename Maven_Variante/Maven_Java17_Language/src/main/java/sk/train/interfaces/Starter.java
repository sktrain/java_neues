package sk.train.interfaces;

public class Starter {

	public static void main(String[] args) {
		 Test t = new Test();
		 System.out.println(t.getRandomValue());
		 
		 TestImpl t1 = new TestImpl();
		 //nicht möglich
		 //t1.isValidValue(1);
		 
		 System.out.println(InterfaceWithStatic.isValidValue(1));
	}

}
