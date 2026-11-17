package sk.train.textblocks;

public class TextblockSample {

	public static void main(String[] args) {

		String fall1 = "<html>\n" +
	                  "    <body>\n" +
	                  "        <p>Hello, world</p>\n" +
	                  "    </body>\n" +
	                  "</html>\n";
		
		
		String fall2 = """
				<html>
				    <body>
				        <p>Hello, world</p>
				    </body>
				</html>
				""";
		
		System.out.println(fall1.equals(fall2));
		System.out.println(fall1 == fall2);
		System.out.println(fall1);
		
		
		String fall3 = """
				      <html>
				          <body>
				              <p>Hello, world</p>
				          </body>
				      </html>
				""";
		
		System.out.println(fall1.equals(fall3));
		System.out.println(fall3);
		
		
		String fall4 = """
				<html>
				    <body>
				       <p>Hello, world</p>
				    </body>
				</html> """;

		System.out.println(fall4.equals(fall3));
		System.out.println(fall4);
		
		
		//Escape des Zeilenumbruchs
		String fall5 = """
                Lorem ipsum dolor sit amet, consectetur adipiscing \
                elit, sed do eiusmod tempor incididunt ut labore \
                et dolore magna aliqua.\
                """;

		System.out.println(fall5);
		
		
		//Trailing Whitespace behalten: jede Zeile ist 6 Zeichen lang
		String fall6new = """
			    red  \s
			    green\s
			    blue \s
			    """;
		
		String fall6old =  "red   \n" 
		                 + "green \n"
		                 + "blue  \n";
		
		System.out.println(fall6old == fall6new);
	}

}
