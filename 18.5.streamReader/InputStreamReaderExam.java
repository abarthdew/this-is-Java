import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExam {
  public static void main(String[] args) throws Exception {

    InputStream is = System.in;
    Reader reader = new InputStreamReader(is);

    int readCharNo;
    char[] cbuf = new char[100];
    while ((readCharNo = reader.read(cbuf)) != -1) {
      String data = new String(cbuf, 0, readCharNo);
      System.out.println(data);
            /*
            바이트 입력 스트림을 문자 입력 스트림으로 변환
            바이트 입력 스트림을 문자 입력 스트림으로 변환
             */
    }
    reader.close();
    is.close();

  }
}