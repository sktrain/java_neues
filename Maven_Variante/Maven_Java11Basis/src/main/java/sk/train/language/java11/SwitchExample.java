package sk.train.language.java11;

public class SwitchExample {
    public static void main(String[] args) {
        var s = "";
        var i = switch (s) { // i ist polymorph (Object, Serializable, ...)
            case "zweig1", "zweig2" -> "String1"; //String
            case "zweig3", "zweig4" -> 2; //int
            case "" -> null;
            case null -> 3;
            default -> throw new IllegalArgumentException();
        }; //Ausdruck abgeschlossen mit ;
        System.out.println(i);
    }
}
