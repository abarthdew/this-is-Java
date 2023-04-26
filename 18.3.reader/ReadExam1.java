import java.io.FileReader;
import java.io.Reader;

public class ReadExam1 {
    public static void main(String[] args) throws Exception {
        
        Reader reader = new FileReader("C:/Users/auswo/Downloads/PortableGit/test.txt"); // 'BC'가 입력된 텍스트 파일
        int readData; // reader가 읽은 문자를 저장
        while (
            (readData = reader.read()) // readData(4byte)의 끝 2byte에 각각 문자 저장
            != -1) {
            System.out.print((char)readData);
            /*
             * BC
             */
        }

        // while (true) {
        //     readData = reader.read();
        //     if (readData == -1) {
        //         break;
        //     }
        //     System.out.print((char)readData);
        // }

        reader.close();

    }
}
