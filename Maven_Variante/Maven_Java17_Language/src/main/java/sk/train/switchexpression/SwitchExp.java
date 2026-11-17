package sk.train.switchexpression;

public class SwitchExp {
	
	public static void main(String[] args) {
		
		String s = "zweig2";

		switch (s) {
			case "zweig1", "zweig2"  -> System.out.println(1);
			//case "zweig3", "zweig2"  -> System.out.println(2); //not allowed
			case "zweig3", "zweig4"  -> {int i = 2;
										 System.out.println(2);}
			default -> throw new IllegalArgumentException();			
		}
		
		var i = switch (s) {
			case "zweig1", "zweig2"  -> "Hallo";
			case "zweig3", "zweig4"  -> 2;
			default -> throw new IllegalArgumentException();			
		};
		
		
		Object o = switch (s) {
			case "zweig1", "zweig2"  -> "1";
			case "zweig3", "zweig4"  -> 2;
			default -> throw new IllegalArgumentException();			
		};
		System.out.println(o.getClass());
		
		System.out.println(switch (s) {
			case "zweig1", "zweig2"  -> "1";
			case "zweig3", "zweig4"  -> 2;
			default -> throw new IllegalArgumentException();});
		
		s= "hey";
		int n = switch (s) {
			case "zweig1", "zweig2"  -> { int k = "Hallo".length();
										  yield k;										  
										}
			case "zweig3", "zweig4"  -> 2;	
			default -> 1;
		};
		
		int result = switch (s) {
		    case "Foo": 
		        yield 1;
		    case "Bar":
		    	yield 2;		       
		    default:
		        System.out.println("Neither Foo nor Bar, hmmm...");
		        yield 0;
		};
		System.out.println(result);
		
		

	}

}
