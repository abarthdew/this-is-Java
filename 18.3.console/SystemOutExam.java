import java.io.OutputStream;

public class SystemOutExam {
  public static void main(String[] args) throws Exception {

    OutputStream os = System.out;

    for (byte b = 48; b < 58; b++) {
      os.write(b); // 한 byte씩 출력
      // 0123456789
      // (48이 아스키 코드로 0 ~ 57이 9)
    }

    // 개행
    os.write(13);

    for (byte b = 97; b < 123; b++) {
      os.write(b);
      // abcdefghijklmnopqrstuvwxyz
    }

    String hangul = "가나다라마바사";
    byte[] hanByte = hangul.getBytes();
    os.write(hanByte); // 가나다라마바사가나다라마바사

    os.flush();
    os.close();

  }
}
