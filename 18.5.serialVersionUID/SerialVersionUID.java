import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUID {
    public static void main(String[] args) throws Exception {
        
        FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialVersionUID/dir/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        SerialClassC classC = new SerialClassC(); // 저장할 객체 만들기
        classC.field1 = 1;

        oos.writeObject(classC);
        oos.flush();
        oos.close();
        fos.close();
        // C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialVersionUID/dir/Object.dat에 SerialClassC 객체가 저장됨

    }
}
