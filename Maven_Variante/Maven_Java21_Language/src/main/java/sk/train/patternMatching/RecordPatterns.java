package sk.train.patternMatching;


record Point(int x, int y) {}


public class RecordPatterns {
	
	public static void main(String[] args) {
		
		Point p = new Point(1,1);
		printSumJava16(p);
		printSumJava21(p);
		printSumJava21(null);   //null trifft kein Pattern!		
	}
	
	static void printSumJava16(Object obj) {
	    if (obj instanceof Point p) {
	        int x = p.x();
	        int y = p.y();
	        System.out.println(x + y);
	    }
	}
	
	static void printSumJava21(Object obj) {
	    if (obj instanceof Point(int x, int y)) {
	        System.out.println(x + y);
	    }
	    else {
	    	//p is not valid here
	    	//System.out.println(p.x);
	    	System.out.println("no match");
	    }
	}

}
