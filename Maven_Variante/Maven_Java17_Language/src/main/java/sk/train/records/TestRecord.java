package sk.train.records;

public class TestRecord {

	public static void main(String[] args) {
		 
		Point p = new Point(-1, 2);
		System.out.println(p.x());
		System.out.println(p);
		
		
		RecordCicle r1 = new RecordCicle(1, null);
		System.out.println(r1);

	}

}
