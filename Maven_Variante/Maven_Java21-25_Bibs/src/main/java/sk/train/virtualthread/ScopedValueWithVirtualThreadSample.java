package sk.train.virtualthread;

public class ScopedValueWithVirtualThreadSample {

    static final ScopedValue<String> REQ_ID =
            ScopedValue.newInstance();

    static Runnable r= () -> {
        System.out.println(Thread.currentThread().getName());
        ScopedValue.where(REQ_ID, "4711").run(() -> f1());
    };
    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.ofVirtual().name("Virtual").start(r);
        t.join();
    }

    private static void f1() { f2(); }  //nutzt Value nicht

    private static void f2() {
        System.out.println(Thread.currentThread().getName() + ": " + REQ_ID.get()); }

}
