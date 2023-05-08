import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExam {
    public static void main(String[] args) throws Exception {
        
        FileOutputStream fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.streamReader/file.txt");
        Writer writer = new OutputStreamWriter(fos);

        String data = "Convert primitive-based stream to character-based stream";
        writer.write(data);
        // 파일에 문자 저장됨

        writer.flush();
        writer.close();
        fos.close();
        
        System.out.println("파일 저장 완료");

    }
}
