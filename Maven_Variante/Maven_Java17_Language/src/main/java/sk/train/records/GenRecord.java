package sk.train.records;

//kein sonderlich sinnhaftes Beispiel
import java.util.function.Function;

public record GenRecord<T> ( T t) implements Function<T, String>{

	@Override
	public String apply(T t) {
		return t.toString();
	}
	
	public static void main(String[] args) {
		GenRecord<Point> g = new GenRecord<Point>(null);
		System.out.println(g.apply(new Point(1,1)));
	}
}
