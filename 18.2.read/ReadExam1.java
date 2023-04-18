import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam1 {
    public static void main(String[] args) throws Exception {
        
        InputStream is = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/LICENSE.txt");
        // LICENSE.txt 텍스트 파일 읽기

        int readByte;
        while(
            (readByte = is.read()) // 1byte씩 읽은 값을 readByte에 넣음
            != -1 // -1이 리턴 될 때까지(다 읽을 때까지) 반복
            ) {
                System.out.println(readByte);
                // 파일의 byte 수만큼 반복됨
                /*
                100
                105
                116
                105
                111
                110
                ...(문자에 대한 ASCII 코드 값 출력됨)...
                 */
        }

        // 다른 표현
        while(true) {
            readByte = is.read();
            if (readByte == -1) break;
            System.out.println((char)readByte); // 강제타입 변환, 문자 출력
            /*
            L
            i
            c
            e
            n
            s
            e
            ...
             */
        }

    }
}