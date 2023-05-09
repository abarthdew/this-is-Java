import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDExam2 {
    public static void main(String[] args) throws Exception {
        
        // SerialVersionUIDExam1을 복원하는 실행 클래스
        // ㄴ(C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialVersionUID/dir/Object.dat) 에 저장한 classC를 복원

        FileInputStream fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.serialVersionUID/dir/Object.dat"); // 파일에 있는 객체를 읽음
        ObjectInputStream ois = new ObjectInputStream(fis);

        SerialClassC classC = (SerialClassC)ois.readObject(); // 읽은 객체 대입
        System.out.println(classC.field1); // 1 (잘 복원됨)

        // main 메서드가 끝나면 스트림은 닫히지만, 명시적으로 종료해 줌
        ois.close();
        fis.close();

    }
}
