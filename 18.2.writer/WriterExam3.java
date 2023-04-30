import java.io.FileWriter;
import java.io.Writer;

public class WriterExam3 {
    public static void main(String[] args) throws Exception {
        
        Writer writer = new FileWriter("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\test3.txt");
        char[] data = "study writer3".toCharArray();
        
        writer.write(data, 1, 2); // test3.txt 파일에 tu 만 저장됨

        writer.flush();
        writer.close();

    }
}
