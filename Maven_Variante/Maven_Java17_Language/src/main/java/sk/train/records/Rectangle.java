package sk.train.records;

record Rectangle(double length, double width) {
    
    // Static field
    static double goldenRatio;

    // Static initializer
    static {
        goldenRatio = (1 + Math.sqrt(5)) / 2;
    }

    // Static method
    public static Rectangle createGoldenRectangle(double width) {
        return new Rectangle(width, width * goldenRatio);
    }
    
    
    public static void main(String[] args) {
		
    	Rectangle r1 = new Rectangle(1.5, 2.5);
		System.out.println(r1);
		
		r1 = createGoldenRectangle(1);
		System.out.println(r1);
	}
}