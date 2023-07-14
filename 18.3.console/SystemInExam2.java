import java.io.InputStream;

public class SystemInExam2 {
  public static void main(String[] args) throws Exception {

    InputStream is = System.in;
    byte[] datas = new byte[100]; // 읽은 데이터를 저장할 byte 배열

    System.out.print("이름: ");

    int nameBytes = is.read(datas);
    String name = new String(datas, 0, nameBytes - 2);

    System.out.println(name);
        /*
        이름: 안녕하세요 (입력)
        안녕하세요 (출력)
         */

  }
}
