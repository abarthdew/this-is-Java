import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam2 {
  public static void main(String ar[]) throws Exception {

    OutputStream os = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/test.txt");
    byte[] data = "ABC".getBytes();
    os.write(data); // 딱 한 번 실행되므로 보다 효율적
    os.flush();
    os.close();

  }
}