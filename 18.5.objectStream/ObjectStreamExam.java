import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExam {
    public static void main(String[] args) throws Exception {
        
        FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.objectStream/dir/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new Integer(10));
        oos.writeObject(new Double(3.14));
        oos.writeObject(new int[]{1,2,3});
        oos.writeObject(new String("grace"));

        oos.flush();
        oos.close();
        fos.close();

        // 저장된 객체 읽기
        FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.objectStream/dir/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 순서대로 대입
        Integer obj1 = (Integer) ois.readObject(); // oos.writeObject(new Integer(10));
        Double obj2 = (Double) ois.readObject(); // oos.writeObject(new Double(3.14));
        int[] obj3 = (int[]) ois.readObject(); // oos.writeObject(new int[]{1,2,3});
        String obj4 = (String) ois.readObject(); // oos.writeObject(new String("grace"));

        ois.close();
        fis.close();

        System.out.println(obj1); // 10
        System.out.println(obj2); // 3.14
        System.out.println(obj3[0] + obj3[1] + obj3[2]); // 6
        System.out.println(obj4); // grace

    }
}
