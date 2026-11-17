package sk.train.records;

import java.util.Comparator;

public record GenericRecord <T> (Comparable<T> c1, Comparable<T> c2) implements Comparator<T>
{

	@Override
	public int compare(T o1, T o2) {
		return ((Comparable<T>) o1).compareTo(o2);
	}


	public static void main(String[] args) {
		Point c1 = new Point(1,1);
		Point c2 = new Point(2,2);
		
		var genericRecord = new GenericRecord<>( c1, c2);
		System.out.println(genericRecord.compare(c1, c2));
		System.out.println(genericRecord.compare(c2, c1));
		
		String s1 = "Hallo";
		String s2 = "Huhu";
		var genericRecord2 = new GenericRecord<>(s1, s2);
		System.out.println(genericRecord2.compare(s1, s2));
		
	}

}
