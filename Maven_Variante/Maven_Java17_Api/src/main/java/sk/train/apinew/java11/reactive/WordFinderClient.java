package sk.train.apinew.java11.reactive;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Beispielprogramm f�r das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017 by Michael Inden 
 */
public class WordFinderClient
{
    public static void main(final String[] args) throws IOException, InterruptedException
    {
        final WordPublisher finder = new WordPublisher("private", getInputFiles());
        System.out.println(getInputFiles());
       // First5Subscriber subscriber = new First5Subscriber(System.out::println);
       //finder.subscribe(new First5Subscriber(System.err::println));
        WordSubscriber subscriber = new WordSubscriber();
        finder.subscribe(subscriber);
        finder.performSearch();

        Thread.sleep(2_000); // auf das Ende der Verarbeitung warten

        finder.terminate();
    }

    private static List<Path> getInputFiles()
    {
    	//[src\main\java\ch3_1_3\reactivestreams\WordPublisher.java, src\main\java\ch3_1_3\reactivestreams\WordFinderClient.java]
    	//C:\Users\stephan\workspaces\eclipse\Java_Update_2021\Maven_Java11Basis\src\main\java\sk\train\apinew\java11\reactive
    	final String srcPath = "src/main/java/";
        return List.of(Paths.get(srcPath + "sk/train/apinew/java11/reactive/WordPublisher.java"),
                       Paths.get(srcPath + "sk/train/apinew/java11/reactive/WordFinderClient.java"));
    }
    
}
