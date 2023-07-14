import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialClassExam {
  public static void main(String[] args) throws Exception {

    FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.objectStream/dir/Serial.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    SerialClassA classA = new SerialClassA();
    classA.field1 = 1;
    classA.field2.field1 = 2;
    classA.field3 = 3;
    classA.field4 = 4;

    oos.writeObject(classA);
    oos.flush();
    oos.close();
    fos.close();

    FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.objectStream/dir/Serial.dat");
    ObjectInputStream ois = new ObjectInputStream(fis);

    SerialClassA v = (SerialClassA) ois.readObject();
    System.out.println(v.field1); // 1
    System.out.println(v.field2.field1); // 2
    System.out.println(v.field3); // 3
    System.out.println(v.field4); // 0 (해당 필드는 byte화가 되지 않아 출력되지 않음 - SerialClassA 객체로 복원할 때 기본값이 들어 있음)

  }
}
