import java.io.IOException;

public class ByteToStringExam {
  public static void main(String[] args) throws IOException {

    byte[] bytes1 = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
    String str1 = new String(bytes1);
    System.out.println(str1); // Hello Java

    byte[] bytes2 = new byte[100];
    System.out.print("입력: ");
    int readByteNo = System.in.read(bytes2);
    String str2 = new String(bytes2, 0, readByteNo - 2);
    System.out.println(str2);
        /*
        입력: java
        java
         */

  }
}