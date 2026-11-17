package sk.train.kleinigkeiten;

public class Deprecation {
	
	public static void main(String[] args) {
		//Deprecated
        someOldMethod();
	}
	
	/**
     * @deprecated this method is replaced by someNewMethod() which is more stable
     */
    @Deprecated(since = "11", forRemoval = true)
    private static void someOldMethod()
    {
        // ...
    }

}
