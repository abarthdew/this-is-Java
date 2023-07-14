import java.io.FileReader;

public class FileReaderExam {
  public static void main(String[] args) throws Exception {

    FileReader fr = new FileReader("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file1.txt");

    int readCharNo; // 읽은 문자 수 저장
    char[] cbuf = new char[100]; // 읽은 문자 저장
    while ((readCharNo = fr.read(cbuf)) != -1) {
      String data = new String(cbuf, 0, readCharNo);
      System.out.println(data); // study java!
    }
    fr.close();

  }
}
