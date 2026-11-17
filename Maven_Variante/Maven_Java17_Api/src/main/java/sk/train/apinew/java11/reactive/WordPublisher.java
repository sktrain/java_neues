package sk.train.apinew.java11.reactive;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Stream;

/**
 * Beispielprogramm für das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class WordPublisher implements Flow.Publisher<String>
{
    private final String                      word;

    private final List<Path>                  paths;

    private final SubmissionPublisher<String> publisher;

    private final ExecutorService             executor = Executors.newFixedThreadPool(4);

    public WordPublisher(final String word, final List<Path> paths)
    {
        this.word = word;
        this.paths = Collections.unmodifiableList(paths);
        this.publisher = new SubmissionPublisher<>();
    }

    @Override
    public void subscribe(final Subscriber<? super String> subscriber)
    {
        publisher.subscribe(subscriber);
    }

    public void performSearch() throws InterruptedException
    {
        for (final Path path : paths)
        {
            executor.execute(() -> {
                final Stream<String> occurences = findWord(word, path);
                occurences.forEach(line -> publisher.submit("file: " + path + " : " + line));
            });
        }
    }

    public void terminate() throws InterruptedException
    {
        // führt zum Aufruf von onComplete()        
        publisher.close();
        
        executor.shutdown();
        System.out.println(LocalDateTime.now() + " Termination");
    }

    private Stream<String> findWord(final String wordToSearch, final Path path)  
    {
        try
        {
            final Charset utf8 = StandardCharsets.UTF_8;
            final List<String> lines = Files.readAllLines(path, utf8);
            return lines.stream().filter(line -> line.contains(wordToSearch));
        }
        catch (final IOException e)
        {
            return Stream.of();
        }
    }
}
