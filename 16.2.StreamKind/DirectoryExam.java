import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryExam {
  public static void main(String[] args) throws IOException {

    Path path = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/16.2.StreamKind");
    Stream<Path> stream = Files.list(path);
    stream.forEach(p -> System.out.println(p.getFileName()));
        /*
        ArrayExam.java
        CollectionExam.java
        DirectoryExam.java
        FileContentExam.java
        IntRangeExam.java
        linedata.txt
         */

  }
}
