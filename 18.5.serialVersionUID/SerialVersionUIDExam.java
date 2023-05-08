import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDExam {
    public static void main(String[] args) throws Exception {
        
        // SerialVersionUID 복원

        FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialVersionUID/dir/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        SerialClassC classC = (SerialClassC)ois.readObject(); // 읽은 객체 대입
        System.out.println(classC.field1);

        ois.close();
        fis.close();

    }
}
