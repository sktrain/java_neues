package sk.train.mehrfachvererbung;

public interface BlueEyes {	
	default String getColor() {
		return "blue";
	}
}
