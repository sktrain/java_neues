package other.samples.reactive;



import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;




public class SimpleReactiveStreamsApp {

    /**
     * Demonstrates SubmissionPublisher instantiations
     */
    @SuppressWarnings({ "unused", "resource" })
	void instantiateSubmissionPublisher() {
        // has default buffer size of 256
        var pub1 = new SubmissionPublisher<String>();

        // custom executor and buffer size
        var pub2 = new SubmissionPublisher<String>(
                ForkJoinPool.commonPool(),
                0
        );

        // custom executor, buffer size and error-handler
        var pub3 = new SubmissionPublisher<String>(
                Runnable::run,
                0,
                (subscr, err) -> err.printStackTrace()
        );
    }

   
}
