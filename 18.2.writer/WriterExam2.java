import java.io.FileWriter;
import java.io.Writer;

public class WriterExam2 {
    public static void main(String[] args) throws Exception {
        
        Writer writer = new FileWriter("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\test2.txt");
        char[] data = "study writer2".toCharArray();
        
        // 모든 문자가 한까번에 전송됨(for 문 필요 없음)
        // 단 한번만 실행
        writer.write(data); 

        // 모든 문자가 한꺼번에 출력됨(for 문 필요 없음)
        System.out.print(data); // study writer2

        writer.flush();
        writer.close();

    }
}
