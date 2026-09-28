package sk.train.p1;

public class Sample8{

    public static void main(String[] args) {

        //problemfrei
        System.out.println("Hello World!");

        //interne API nutzen
        System.out.println(com.sun.awt.AWTUtilities.isWindowShapingSupported());
        //System.out.println(sun.misc.VM.isBooted());
        
        //JAXB ist Bestandteil der SE
        //JAXB mit Pair nutzen
        javax.xml.bind.JAXB.marshal(new Pair(), System.out);
        
        //JAXB allgemein nutzen
        javax.xml.bind.JAXB.marshal("Hallo", System.out);
    }
}

class Pair{
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
