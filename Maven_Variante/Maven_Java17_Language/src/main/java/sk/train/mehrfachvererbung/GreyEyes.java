package sk.train.mehrfachvererbung;

public interface GreyEyes {	
	default String getColor() {
		return "grey";
	}
}
