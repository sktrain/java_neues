/****************************************************************
 * Quelle: https://javapro.io/2026/03/05/java-25-and-the-new-age-of-performance-virtual-threads-and-beyond/
 ***************************************************************/

package sk.train.virtualthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadPerformance {

    static void main() throws ExecutionException, InterruptedException {
        try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {
            long t0 = System.nanoTime();
            var futures = IntStream.range(0, 100_000)
                    .mapToObj(i -> exec.submit(() -> { Thread.sleep(50); return i; }))
                    .toList();
            for (var f : futures) f.get();
            long ms = (System.nanoTime() - t0) / 1_000_000;
            System.out.println("Completed in " + ms + " ms");
        }

        try (var exec = Executors.newCachedThreadPool()) {
            long t0 = System.nanoTime();
            var futures = IntStream.range(0, 100_000)
                    .mapToObj(i -> exec.submit(() -> { Thread.sleep(50); return i; }))
                    .toList();
            for (var f : futures) f.get();
            long ms = (System.nanoTime() - t0) / 1_000_000;
            System.out.println("Completed in " + ms + " ms");
        }
    }


}
