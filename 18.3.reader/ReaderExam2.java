import java.io.FileReader;
import java.io.Reader;

public class ReaderExam2 {
    public static void main(String[] args) throws Exception {
        
        Reader reader = new FileReader("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.3.reader\\test.txt");
        int readCharNo; // reader가 읽은 문자 수를 저장
        char[] cbuf = new char[2];
        String data = "";
        while (
            (readCharNo = reader.read(cbuf))
            != -1) {
            data += new String(cbuf, 0, readCharNo); // 0인덱스 부터 읽은 문자 수만큼만 누적
        }
        System.out.println(data);
        /*
        * study
        */

        reader.close();

    }
}
