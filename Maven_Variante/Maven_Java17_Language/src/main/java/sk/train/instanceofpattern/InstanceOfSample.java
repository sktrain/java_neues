package sk.train.instanceofpattern;

public class InstanceOfSample {

	public static void main(String[] args) {
		//bisher
		Object o1 = "Hallo";  
		if (o1 instanceof String) {
			int len = ((String)o1).length();   }

		//neu
		if (o1 instanceof String s) {
			int len = s.length();   }
		
		//Scope der Variablen beachten!
		if (!(o1 instanceof Number s)) {
			//int val = s.intValue();
		} else {
			int val = s.intValue();
		}		

	}

}
