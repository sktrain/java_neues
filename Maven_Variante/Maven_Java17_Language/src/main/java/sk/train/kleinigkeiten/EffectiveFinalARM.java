package sk.train.kleinigkeiten;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class EffectiveFinalARM {

	public static void main(String[] args) {

		//effective final resources in ARM
		BufferedInputStream bis = new BufferedInputStream(System.in);
        BufferedOutputStream bos = new BufferedOutputStream(System.out);  //effective final
        try (bis; bos){

        	//...
        	System.out.println(("try"));
        	
        }
        catch(IOException e) {
        	//...
        }
        
        try {
        	bis.available();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
