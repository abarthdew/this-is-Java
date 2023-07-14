import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExam {
  public static void main(String[] args) throws Exception {

    FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.printStream/dir/file.txt");
    PrintStream ps = new PrintStream(fos);

    ps.print("PrintStream: ");
    ps.print("likewise ");
    ps.print("printer is printing data.. ");

    ps.flush();
    ps.close();
    fos.close();

  }
}
