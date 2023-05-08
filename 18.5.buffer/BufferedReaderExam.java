import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExam {
    public static void main(String[] args) throws Exception {
        
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("입력: ");
        String lineString = br.readLine();
        System.out.println("출력: " + lineString);
        /*
        입력: 
        한 줄 전체를 읽음
        출력: 한 줄 전체를 읽음
         */

        br.close();
        reader.close();
        is.close();

    }
}
