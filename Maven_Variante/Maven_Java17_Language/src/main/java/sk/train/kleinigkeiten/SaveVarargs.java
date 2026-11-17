package sk.train.kleinigkeiten;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SaveVarargs {
	    
    @SafeVarargs
	public static void alpha(List<String>... args) {
	}

	// @SafeVarargs // not allowed
	public void beta(List<String>... args) { // compiler-warning

	}

	@SafeVarargs
	public final void gamma(List<String>... args) {

	}

	@SafeVarargs  //ab Java 9
	private void delta(List<String>... args) {

	}
	
	@SafeVarargs		//ist nicht save!!
	static void falschSample(List<String> ...stringlists ) {
		
		Object[] array = stringlists;
		List<Integer> li = Arrays.asList(1);
		array[0] = li;
		
		String s = stringlists[0].get(0);
	}
	
	public static void main(String[] args) {
		falschSample(Arrays.asList("Hugo", "Max"));
	}

}
