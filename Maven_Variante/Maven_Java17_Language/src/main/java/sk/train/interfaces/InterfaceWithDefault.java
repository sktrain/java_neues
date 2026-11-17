package sk.train.interfaces;

import java.util.Random;

public interface InterfaceWithDefault {
	
	int MINVALUE = 10;
	int MAXVALUE = 1_000_000;
	
	int getValue();
	
	default int getRandomValue() {
		return getFixValue() + new Random().nextInt(MINVALUE);
	}
	
	private int getFixValue() {
		return 1;
	}
}

class Test implements InterfaceWithDefault{

	@Override
	public int getValue() {
		return getRandomValue();
	}
	
	
	
}
