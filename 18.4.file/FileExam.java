import java.io.File;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileExam {
  public static void main(String[] args) throws Exception {

    File dir = new File("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir");
    File file1 = new File("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file1.txt");
    File file2 = new File("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file2.txt");
    File file3 = new File(new URI("file:///C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file3.txt"));

    if (dir.exists() == false) {
      dir.mkdirs(); // dir 디렉토리가 존재하지 않으면, 만든다
    }

    if (file1.exists() == false) {
      file1.createNewFile();
    } // 파일이 없으면, 만든다
    if (file2.exists() == false) {
      file2.createNewFile();
    }
    if (file3.exists() == false) {
      file3.createNewFile();
    }

    File temp = new File("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir"); // 디렉토리를 파일 객체로 만든다
    File[] contents = temp.listFiles(); // temp 내 존재하는 서브 디렉토리, 파일을 파일 객체로 얻어 배열로 생성

    System.out.println("날짜|시간|형태|크기|이름");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (File file : contents) {
      System.out.print(sdf.format(new Date(file.lastModified())));
      if (file.isDirectory()) { // 디렉토리인가, 파일인가?
        System.out.println("\t<DIR>\t" + file.getName());
      } else {
        System.out.println("\t" + file.length() + "\t" + file.getName());
      }
      System.out.println();
            /*
            날짜|시간|형태|크기|이름
            2023-05-02      0       file1.txt

            2023-05-02      0       file2.txt

            2023-05-02      0       file3.txt
             */
    }

  }
}