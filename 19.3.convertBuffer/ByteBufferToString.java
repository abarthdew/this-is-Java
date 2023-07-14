import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToString {
  public static void main(String[] args) {

    Charset charset = Charset.forName("UTF-8");

    // 문자열 -> 인코딩 -> ByteBuffer
    String data = "hello";
    ByteBuffer byteBuffer = charset.encode(data);
    // 이렇게 얻은 ByteBuffer를 채널을 통해 출력할 수 있음

    // ByteBuffer -> 디코딩 -> CharBuffer -> 문자열
    data
      = charset.decode(byteBuffer) // CharBuffer
      .toString(); // String

    System.out.println("문자열 복원: " + data); // 문자열 복원: hello
  }
}
