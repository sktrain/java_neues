package sk.train.patternMatching;

public class MatchWithGuards {
	
	static void testStringEnhanced(String response) {
	    switch (response) {
	    	case null -> { }
	        case "y", "Y" -> {
	            System.out.println("You got it");
	        }
	        case "n", "N" -> {
	            System.out.println("Shame");
	        }
	        case String s
	        when s.equalsIgnoreCase("YES") -> {
	            System.out.println("You got it");
	        }
	        case String s
	        when s.equalsIgnoreCase("NO") -> {
	            System.out.println("Shame");
	        }
	        case String s -> {
	            System.out.println("Sorry?");
	        }
	    }
	}

	public static void main(String[] args) {

		//.............

	}

}
