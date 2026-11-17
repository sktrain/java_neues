package sk.train.interfaces;

import java.util.Random;

public interface InterfaceWithStatic {
	
	int MINVALUE = 10;
	int MAXVALUE = 1_000_000;
	
	int getValue();
	
	public static boolean isValidValue(int i) {
		return validate(i);
	}
	
	private static boolean validate(int i) {
		return (MINVALUE <= i) & (i <= MAXVALUE);
	}
	
	default int getRandomValue() {
		return getFixValue() + new Random().nextInt(MINVALUE);
	}
	
	private int getFixValue() {
		return 1;
	}
}

class TestImpl implements InterfaceWithStatic{

	@Override
	public int getValue() {
		return getRandomValue();
	}
	
	
	
}
