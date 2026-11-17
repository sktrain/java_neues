package sk.train.apiupdate.java11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

//Java 9: Erweiterungen bei CompletableFuture

public class CompletableFutureSample
{
    public static void main(final String[] args) throws ExecutionException, InterruptedException
    {
        perform();
    }
    
    public static void perform() throws ExecutionException, InterruptedException
    {
        CompletableFuture.supplyAsync(() -> longRunningTask(5000))
                         .completeAsync(() -> Thread.currentThread() + ": async completed")			//neu in Java 9
                         .thenAccept(System.out::println);
        
        CompletableFuture.supplyAsync(() -> longRunningTask(5000))
                         .orTimeout(3000, TimeUnit.MILLISECONDS)			//neu in Java 9
                         .exceptionally(ex -> Thread.currentThread() + ": exception occurred: " + ex)
                         .thenAccept(System.out::println);
        
        CompletableFuture.supplyAsync(() -> longRunningTask(5))
                         .completeOnTimeout(Thread.currentThread() + ": timeout", 2000, TimeUnit.MILLISECONDS)  //neu in Java 9
                         .thenAccept(System.out::println);    
              
        CompletableFuture.failedFuture(new IllegalStateException())
                         .exceptionally(ex -> Thread.currentThread() + ": exception occurred: " + ex)
                         .thenAccept(System.out::println);
                
        // Warten, damit CompletableFuture terminiert
        Thread.sleep(20_000);
    }

    public static String longRunningTask(int duration) 
    {
        System.out.println(Thread.currentThread() + " enter: longRunning");
        try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread() + " exit: longRunning");
        return "message from longrunning";
    }


}
