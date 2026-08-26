package sk.train.virtualthread;

public class ThreadCreationSample {

    public static void main(String[] args) throws InterruptedException {
        Thread.Builder builder =
                Thread.ofVirtual().name("MyThread");
        Runnable task = () -> {
            System.out.println("running vt1");
        };
        Thread virtualThread1 = builder.start(task);


        // oder kompakter
        Thread virtualThread2 = Thread.ofVirtual().start(
                () -> System.out.println("running vt2"));


        // funktioniert auch für platform thread
        Thread platformThread = Thread.ofPlatform().start(
                () -> System.out.println("running pt"));

        // via statischer Methode
        Thread virtualThread3 = Thread.startVirtualThread(
                () -> System.out.println("running vt3"));

        // Erzeugung ohne Start
        Thread virtualThread4 = Thread.ofVirtual().unstarted(
                () -> System.out.println("running vt4"));
        virtualThread4.start();  //expliziter Start

        // Thread-Aufbau via Builder
        Thread p1build = Thread.ofPlatform()
                .name("p1Build")
                .group(Thread.currentThread().getThreadGroup())
                .inheritInheritableThreadLocals(false)
                .priority(Thread.MAX_PRIORITY)
                .stackSize(0)
                .uncaughtExceptionHandler((t, ex) -> System.err.println(ex))
                .unstarted(() -> System.out.println("running p1build"));
        p1build.start();

        Thread.sleep(1000);

    }
}
