import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathExam {
  public static void main(String[] args) {

    Path path = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.path/PathExam.java");
    System.out.println("파일명: " + path.getFileName()); // 파일명: PathExam.java
    System.out.println("부모 디렉토리명: " + path.getParent()); // 부모 디렉토리명: C:\Users\auswo\Downloads\PortableGit\this-is-Java\19.9.path
    System.out.println("중첩 경로수: " + path.getNameCount()); // 중첩 경로수: 7

    System.out.println();

    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println(path.getName(i));
            /*
            Users
            auswo
            Downloads
            PortableGit
            this-is-Java
            19.9.path
            PathExam.java
             */
    }

    System.out.println();

    Iterator<Path> iterator = path.iterator();
    while (iterator.hasNext()) {
      Path temp = iterator.next();
      System.out.println(temp.getFileName());
            /*
            Users
            auswo
            Downloads
            PortableGit
            this-is-Java
            19.9.path
            PathExam.java
             */
    }

  }
}