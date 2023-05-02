import java.io.File;
import java.io.FileWriter;

public class FileWriterExam {
    public static void main(String[] args) throws Exception {
        
        File file = new File("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.4.file/dir/file2.txt");
        FileWriter fw = new FileWriter(file);

        fw.write("FileWriter는 한글로 된" + "\r\n");
        fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
        // File 경로의 파일에 해당 문구 저장됨

        fw.flush();
        fw.close();

        System.out.println("파일 저장");
    }
}
