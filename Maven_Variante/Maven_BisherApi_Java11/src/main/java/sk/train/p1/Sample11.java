package sk.train.p1;


public class Sample11 {

    public static void main(String[] args) {

    	//problemfrei
        System.out.println("Hello World!");

        //interne API nutzen
        //com.sun.awt.AWTUtilities: deprecated in Java10, removed in Java11!!
        //System.out.println(com.sun.awt.AWTUtilities.isWindowShapingSupported());  
        System.out.println(java.util.Arrays.toString(jdk.internal.misc.VM.getRuntimeArguments()));        
        //Abhilfe für Compiler: --add-exports java.base/jdk.internal.misc=ALL-UNNAMED 
        //f�r VM ebenfalls notwendig
        //allerdings fügt Eclipse die Optionen des Compilers auch dem VM-Aufruf automatisch hinzu 

        //nutzen von JAXB: JAXB ab Java11 nicht mehr Teil der SE
        //muss als externe Library hinzugefügt werden
        //JAXB mit Pair nutzen
        javax.xml.bind.JAXB.marshal(new Pair(), System.out);
        
        //JAXB hat gelernt!
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
