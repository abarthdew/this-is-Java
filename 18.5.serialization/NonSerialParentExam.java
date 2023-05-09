import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerialParentExam {
    public static void main(String[] args) throws Exception {
        
        // 파일에 Child 객체 저장
        FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialization/dir/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Child185 child = new Child185();
        child.field1 = "tommy";
        child.field2 = "grace";

        oos.writeObject(child); // 이 메서드가 호출되는 즉시, Child의 재정의된 메서드 호출
        oos.flush();

        oos.close();
        fos.close();

        // 읽기
        FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialization/dir/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Child185 v = (Child185) ois.readObject();

        System.out.println(v.field1); // tommy // 만약 Child에 메서드 재정의가 없었더라면, null이 출력됨
        System.out.println(v.field2); // grace

        ois.close();
        fis.close();

    }
}
