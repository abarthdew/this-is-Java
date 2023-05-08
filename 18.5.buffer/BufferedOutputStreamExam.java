import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamExam {
    public static void main(String[] args) throws Exception {
        
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        int data = -1; // 읽은 바이트를 저장할 변수
        // 복사 전/후 시간 측정
        long start = 0;
        long end = 0;

        // 1.
        fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/test.png");
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/dir/copy.png"); // fis 매개변수 경로에 있는 파일을 여기로 복사
        
        start = System.currentTimeMillis();

        while((data = bis.read()) != -1) {
            fos.write(data);
        }
        fos.flush();
        end = System.currentTimeMillis();
        fos.close();
        bis.close();
        fis.close();
        System.out.println("출력 스트림의 버퍼를 사용하지 않았을 때: " + (end - start) + "ms");
        // 출력 스트림의 버퍼를 사용하지 않았을 때: 4574ms


        // 2.
        fis = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/test.png");
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/dir/copy.png"); // fis 매개변수 경로에 있는 파일을 여기로 복사
        bos = new BufferedOutputStream(fos); // 출력 스트림 버퍼 추가
        
        start = System.currentTimeMillis();

        while((data = bis.read()) != -1) {
            bos.write(data);
        }
        fos.flush();
        end = System.currentTimeMillis();
        bos.close();
        fos.close();
        bis.close();
        fis.close();
        System.out.println("출력 스트림의 버퍼를 사용했을 때: " + (end - start) + "ms");
        // 출력 스트림의 버퍼를 사용했을 때: 57ms

    }
}
