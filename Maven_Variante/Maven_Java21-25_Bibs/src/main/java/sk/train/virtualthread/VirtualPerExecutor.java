package sk.train.virtualthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class VirtualPerExecutor {

    public static void main(String[] args) {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                long id = Thread.currentThread().threadId();
                LockSupport.parkNanos(1_000_000_000);  //simuliert Blocking
                System.out.println(id);
            });
        }
        service.close();
    }
}
