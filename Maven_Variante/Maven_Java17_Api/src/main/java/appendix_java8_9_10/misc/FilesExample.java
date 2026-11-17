package appendix_java8_9_10.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class FilesExample 
{
	public static void main(final String[] args) throws IOException 
	{	
		final String tempDirPath = System.getProperty("java.io.tmpdir");
		final Path destinationFile = Paths.get(tempDirPath + "/WriteText.txt");
		final List<String> content = List.of("This", "is", "the", "content");
		
		// $\mbox{\bfseries Datei schreiben }$
		final Path resultFile = Files.write(destinationFile, content, 
	                                        StandardOpenOption.CREATE, 		 
	                                        StandardOpenOption.APPEND);
		// $\mbox{\bfseries Zeilenweise als Stream<String> einlesen }$
		final Stream<String> contentAsStream = Files.lines(resultFile);
		
		// $\mbox{\bfseries Filtern und Gruppieren }$
		final Map<Integer, List<String>> filterdAndGrouped = contentAsStream.
	                              filter(word -> word.length() > 3).
	                              collect(Collectors.groupingBy(String::length));
		System.out.println(filterdAndGrouped);		

		// $\mbox{\bfseries Verzeichnis als Stream<Path> einlesen }$
		final Stream<Path> tmpDirContent = Files.list(Paths.get(tempDirPath));

		// $\mbox{\bfseries Fallstrick: endsWith arbeitet auf Path-Komponenten, nicht auf Dateinamen!}$
		tmpDirContent.filter(path -> path.toString().endsWith(".txt")).
		                                             forEach(System.out::println);
	}
}
