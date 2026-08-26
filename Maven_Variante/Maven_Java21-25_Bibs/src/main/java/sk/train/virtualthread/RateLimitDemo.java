/*++++++++++++++++++++++++++++++++++++***************************
Quelle: https://dev.java/learn/new-features/virtual-threads/
****************************************************************/

//Rate Limiting
//The following sample program shows rate limiting with a simple semaphore
// that allows a small number of concurrent requests.
// When the maximum is exceeded, the Semaphore.acquire() method blocks,
// but that is ok. With virtual threads, blocking is cheap.


package sk.train.virtualthread;

import java.util.*;
import java.util.concurrent.*;
import java.net.*;
import java.net.http.*;

public class RateLimitDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        List<Future<String>> futures = new ArrayList<>();
        final int TASKS = 250;
        for (int i = 1; i <= TASKS; i++)
            futures.add(service.submit(() -> get("https://horstmann.com/random/word")));
        for (Future<String> f : futures)
            System.out.print(f.get() + " ");
        System.out.println();
        service.close();
    }

    private static HttpClient client = HttpClient.newHttpClient();

    private static final Semaphore SEMAPHORE = new Semaphore(20);

    public static String get(String url) {
        try {
            var request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            SEMAPHORE.acquire();
            try {
                Thread.sleep(100);
                return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            } finally {
                SEMAPHORE.release();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            var rex = new RuntimeException();
            rex.initCause(ex);
            throw rex;
        }
    }
}