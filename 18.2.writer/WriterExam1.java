import java.io.FileWriter;
import java.io.Writer;

public class WriterExam1 {
  public static void main(String[] args) throws Exception {

    Writer writer = new FileWriter("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\test.txt");
    char[] data = "study writer".toCharArray(); // 문자열에서 char 배열을 얻어 냄
    for (int i = 0; i < data.length; i++) { // char 배열의 문자 길이만큼 반복
      writer.write(data[i]); // C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\test.txt에 문자열 저장됨
      System.out.print(data[i]); // 문자열 출력
            /*
            study writer
             */
    }
    writer.flush();
    writer.close();

  }
}
