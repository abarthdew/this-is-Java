import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamExam {
   public static void main(String[] args) throws Exception {
    
        // 버퍼를 사용했을 경우/하지 않았을 경우 시간 차이는?

        long start = 0;
        long end = 0;

        FileInputStream fis1 = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/test.png");
        start = System.currentTimeMillis();
        
        while(fis1.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("입력 스트림의 버퍼를 사용하지 않았을 때: " + (end-start) + "ms");
        // 사용하지 않았을 때: 2728ms
        fis1.close();

        FileInputStream fis2 = new FileInputStream("C:/Users/auswo/Downloads/PortableGit/this-is-Java/18.5.buffer/test.png");
        BufferedInputStream bis = new BufferedInputStream(fis2);
        start = System.currentTimeMillis();
        
        while(bis.read() != -1) {}

        end = System.currentTimeMillis();
        System.out.println("입력 스트림의 버퍼를 사용했을 때: " + (end-start) + "ms");
        // 사용했을 때: 14ms
        bis.close();
        fis2.close();

   } 
}
