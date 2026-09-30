package sk.train.apinew.java11;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/** Prozess-System zugreifen: ProcessHandle (ab Java 9)
 *
 */

public class ProcessApi {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//printProcessInfo(ProcessHandle.current());
		//printAllProcessInfo();
		//printChildProcessInfo();
		//destroyProcess();
		terminateAndThen();
	}

	
	private static void printProcessInfo(ProcessHandle processHandle) {		
		System.out.println("Aktuelle Process-ID: " + processHandle.pid());
		System.out.println(processHandle.info());
		//System.out.println(processHandle.info().startInstant());		
	}
	
	//alle Prozesse, die für uns sichtbar sind
	private static void printAllProcessInfo() {		
		Stream<ProcessHandle> sph = ProcessHandle.allProcesses();
		sph.forEach(ProcessApi::printProcessInfo);		
	}
	
	private static void printChildProcessInfo() throws IOException {
		//weiteren Prozess erzeugen
		Runtime.getRuntime().exec("calc.exe");
		Stream<ProcessHandle> sphc = ProcessHandle.current().children();
		Stream<ProcessHandle> sphd = ProcessHandle.current().descendants();
		sphc.forEach(ProcessApi::printProcessInfo);	
		sphd.forEach(ProcessApi::printProcessInfo);			
	}

	private static void destroyProcess() throws IOException, InterruptedException {
		//weiteren Prozess erzeugen
		Process p = Runtime.getRuntime().exec(new String[] {"calc.exe"});
		Optional<ProcessHandle> o = ProcessHandle.current().children().findFirst();
		Thread.sleep(2_000);
		o.ifPresent( handle -> System.out.println("destroy: " + handle.destroy()));  //freundliche Aufforderung
		Thread.sleep(2_000);
		o.ifPresent( handle -> System.out.println("kill: " + handle.destroyForcibly()));  //kill		
	}
	
	private static void terminateAndThen() throws IOException, InterruptedException {
		Process p = new ProcessBuilder("calc.exe").start();
		//Thread.sleep(2000);
		Optional<ProcessHandle> o = ProcessHandle.current().children().findFirst();
		o.ifPresent( handle -> { 
								System.out.println("handle ist da");
								CompletableFuture<ProcessHandle> future = handle.onExit();
								future.thenRun( () -> System.out.println("Future"));
								//System.out.println("destroy: " + handle.destroy()); 
								
								//ein wenig warten, um die Ausgabe des Future zu sehen
								try {	//Lambda kann Exception nicht werfen!!
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							   } );		
		
	}	
}
