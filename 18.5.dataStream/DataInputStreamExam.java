import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataInputStreamExam {
  public static void main(String[] args) throws Exception {

    FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.dataStream/dir/primitive.dat");
    DataOutputStream dos = new DataOutputStream(fos);

    dos.writeUTF("홍길동"); // 기본 타입은 아니지만 문자열을 출력하고 싶을 때
    dos.writeDouble(95.5); // double 값 저장
    dos.writeInt(2);
    dos.writeUTF("홍길동2");
    dos.writeDouble(45.65);
    dos.writeInt(3);

    dos.flush();
    dos.close();
    fos.close();
    // C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.dataStream/dir/primitive.dat 파일은 문자 데이터가 아님
    // 그러므로, 메모장에서 열어보면 깨짐

    // 데이터 읽기
    FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.dataStream/dir/primitive.dat");
    DataInputStream dis = new DataInputStream(fis);

    // dos.write()에 저장된 순서에 맞게 읽음
    for (int i = 0; i < 2; i++) {
      String name = dis.readUTF(); // dos.writeUTF("홍길동");
      double score = dis.readDouble(); // dos.writeDouble(95.5);
      int order = dis.readInt(); // dos.writeInt(2);

      System.out.println(name);
      System.out.println(score);
      System.out.println(order);
            /*
            홍길동
            95.5
            2
            홍길동2
            45.65
            3
             */
    }


    dis.close();
    fis.close();

  }
}
