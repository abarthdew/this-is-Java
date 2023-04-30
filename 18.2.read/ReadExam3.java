import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam3 {
    public static void main(String[] args) throws Exception {
        
        InputStream is = new FileInputStream("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.read\\test.txt");
        int readByteNo;
        byte[] readBytes = new byte[8];
        readByteNo = is.read(readBytes, 2, 3);

        for(int i=0; i<readBytes.length; i++) {
            System.out.println(readBytes[i]);
            /* 결과: 8개의 배열 중 2 인덱스 부터 3byte만 저장
            0
            0  
            116
            104
            105
            0  
            0
            0
             */
        }
        
        is.close(); // FileInputStream 사용 후 close()
        // stream 이용 후 자원을 닫음
    }
}
