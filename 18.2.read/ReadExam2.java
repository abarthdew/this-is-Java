import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam2 {
    public static void main(String[] args) throws Exception {
        
        InputStream is = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/LICENSE.txt");
        int readByteNo;
        byte[] readBytes = new byte[300];
        String data = "";

        while(
            (readByteNo = is.read(readBytes)) // 300씩 읽음
            != -1
        ) {
            data = new String(readBytes, 0, readByteNo); // readBytes 배열의 0인덱스부터 readByteNo 인덱스까지 문자 저장
            System.out.println(readByteNo); // 저장된 문자열 수 리턴
            /*
            300
            300
            300
            300
            ...
            300
            165
             */
            System.out.println(data); // 저장된 문자 리턴(출력 생략)
        }
    }
}
