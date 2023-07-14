import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam3 {
  public static void main(String ar[]) throws Exception {

    OutputStream os = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/test.txt");
    byte[] data = "ABC".getBytes();
    os.write(data, 1, 2);
    os.flush();
    os.close();

  }
}