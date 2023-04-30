import java.io.FileWriter;
import java.io.Writer;

public class WriterExam4 {
    public static void main(String[] args) throws Exception {
        
        Writer writer1 = new FileWriter("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\string1.txt");
        Writer writer2 = new FileWriter("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.writer\\string2.txt");
        String data = "Hello Java Pro";

        writer1.write(data); // Hello Java Pro 저장
        writer2.write(data, 1, 2); // el 저장

        writer1.flush();
        writer2.flush();
        writer1.close();
        writer2.close();

    }
}
