package sk.train.records;

public record Point(int x, int y) implements Comparable<Point>
{
	
	
//	public Point(int x, int y) {
//	        if (x <= 0 || y <= 0) {
//	        	this.x = 0; this.y = 0;
//	        } else {
//	        	this.x = x;
//	 	        this.y = y;
//	        }	       
//	}
	
	
	//compact canonical constructor
	public Point {
		if (x <= 0 || y <= 0) {
            //throw new java.lang.IllegalArgumentException(); 
			x = y = 0;
        }
	}
	
	@Override
	public int x() { return this.x < 100 ? this.x : 100; }
	public int y() { return this.y < 100 ? this.y : 100; }
	
	@Override
	public int compareTo(Point o) {
		return (x < o.x) ? 1 : -1;
	}
	
}


