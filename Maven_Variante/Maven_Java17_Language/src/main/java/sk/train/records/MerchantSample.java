package sk.train.records;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MerchantSample {
	
	public static void main(String[] args) {
		//lokaler Record
		record Merchant(String name, double sales, int month){			
//			public Merchant {
//				if (name == null || sales < 0 || month < 1 || month > 12) {
//					throw new java.lang.IllegalArgumentException();
//				}
//			}	
		}
		//Einlesen Simulieren
		List<Merchant> merchants = new ArrayList<>();
		Random r = new Random();
		for (int i=1; i<=100; ++i) {
			Merchant m = new Merchant("Muster"+i, r.nextDouble(10_000), 1 +r.nextInt(12));
			merchants.add(m);
		}
		
		//Sortiert per Monat
		var result = merchants.stream()
		         .sorted(Comparator.comparing(Merchant::month).thenComparing(Comparator.comparing(Merchant::sales).reversed()))
		         .collect(Collectors.groupingBy(Merchant::month, Collectors.toList()));
		
		result.forEach((key, list) -> System.out.println("Monat " + key + ": " + list.get(0)));	 //list.getFirst() ab Java 21
	}
}

	
	
	
	



