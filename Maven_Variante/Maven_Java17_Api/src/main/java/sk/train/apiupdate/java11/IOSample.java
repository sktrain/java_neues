package sk.train.apiupdate.java11;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/** Erweiterungen bei Input/Output
 * 
 */

public class IOSample {

	public static void main(String[] args) throws IOException {

		//Java 9

		final byte[] buffer = { 1, -7, 3, 6 };

		final byte[] result = new ByteArrayInputStream(buffer).readAllBytes();
		System.out.println(Arrays.toString(result));

		new ByteArrayInputStream(buffer).transferTo(System.out);
		System.out.println();
		
		
		//Java 10: auch für Reader/Writer
		
		StringReader sr = new StringReader("Hallo");
		StringWriter sw = new StringWriter();
		sr.transferTo(sw);
		System.out.println(sw);
	    

	}

}

