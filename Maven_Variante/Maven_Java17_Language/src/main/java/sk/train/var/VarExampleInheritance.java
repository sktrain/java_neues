package sk.train.var;

interface If {
	default void f() { System.out.println("method f"); }
}

class A implements If {
	public void g() { System.out.println("method g"); }
}

public class VarExampleInheritance {
	static If getA() { 
		return new A();	}
	
	public static void main(String[] args) {
		var a = getA();
		a.f();  //ist ok
		//unzulässig: 	a.g();
	} 
}

