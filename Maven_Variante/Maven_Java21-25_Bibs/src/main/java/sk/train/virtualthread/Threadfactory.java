package sk.train.virtualthread;

import java.util.concurrent.ThreadFactory;

public class Threadfactory {

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread ft = factory.newThread(() -> System.out.println("running ft"));
        ft.start();

        //oder
        ThreadFactory simple = (Runnable r) -> Thread.ofVirtual().start(r);
        ft = simple.newThread(() -> System.out.println("running ft"));

        //warten auf ft
        ft.join();

    }
}
