package sk.train.patternMatching;

record Rectangle(double length, double width) {}

record Circle(double radius) {}


public class ShapeSample {
	
	public static double getPerimeter(Object shape){
        return switch (shape) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c    -> 2 * c.radius() * Math.PI;
            default          -> throw new 
 							IllegalArgumentException("Unrecognized shape");
        };
    }
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2);
		Circle c = new Circle(2);
		System.out.println(getPerimeter(r));
		System.out.println(getPerimeter(c));
		try {
			System.out.println(getPerimeter(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//OO-Design
		Rectang re = new Rectang(2, 2);
		Circ ci = new Circ(2);
		System.out.println(re.getPerim());
		System.out.println(ci.getPerim());
	}


}


/*************** oder mit OO-Design ********************/

interface Shape {
	double getPerim();
}

record Rectang(double length, double width) implements Shape {

	@Override
	public double getPerim() {
		return 2 * length() + 2 * width();
	}}

record Circ(double radius) implements Shape {

	@Override
	public double getPerim() {
		return 2 * radius() * Math.PI;
	}}


