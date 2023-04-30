import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam1 {
    public static void main(String[] args) throws Exception {
        
        InputStream is = new FileInputStream("C:\\Users\\auswo\\Downloads\\PortableGit\\this-is-Java\\18.2.read\\test.txt");
        // test.txt 텍스트 파일 읽기

        int readByte;
        while(
            (readByte = is.read()) // 1byte씩 읽은 값을 readByte에 넣음
            != -1 // -1이 리턴 될 때까지(다 읽을 때까지) 반복
            ) {
                System.out.println(readByte);
                // 파일의 byte 수만큼 반복됨
                /* (문자에 대한 ASCII 코드 값 출력됨)
                116
                104
                105
                115
                32
                105
                115
                32
                106
                97
                118
                97
                32
                115
                116
                117
                100
                121
                33
                 */
        }

        // 다른 표현
        while(true) {
            readByte = is.read();
            if (readByte == -1) break;
            System.out.println((char)readByte); // 강제타입 변환, 문자 출력
            /*
            t
            h
            i
            s

            i
            s

            j
            a
            v
            a

            s
            t
            u
            d
            y
            !
             */
        }
        is.close();

    }
}