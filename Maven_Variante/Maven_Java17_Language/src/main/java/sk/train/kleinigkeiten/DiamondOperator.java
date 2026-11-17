package sk.train.kleinigkeiten;

import java.util.Comparator;

public class DiamondOperator {

	public static void main(String[] args) {

		//<> for anonymous inner classes
        Comparator<String> c = new Comparator<>() {

			@Override
			public int compare(String o1, String o2) {
				return (o1.length()-o2.length());
			}        	
        };
        
        System.out.println(c.compare("Max", "Stephan"));

	}

}
