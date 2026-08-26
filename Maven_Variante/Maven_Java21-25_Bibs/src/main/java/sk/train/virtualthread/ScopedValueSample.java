package sk.train.virtualthread;

public class ScopedValueSample {

    static final ScopedValue<String> REQ_ID =
            ScopedValue.newInstance();

    public static void main(String[] args) {
        ScopedValue.where(REQ_ID, "4711")
                .run(() -> f1());    }

    private static void f1() { f2(); }  //nutzt Value nicht

    private static void f2() {
        System.out.println(REQ_ID.get()); }

}
