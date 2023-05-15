import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class PerformanceExam {
    public static void main(String[] args) throws Exception {
        
        // 같은 이미지 100 번 복사 성능 테스트

        Path from = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.3.buffer/image.png"); // 원본파일
        Path to1 = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.3.buffer/image2.png"); // 타겟파일(저장할 파일)
        Path to2 = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.3.buffer/image3.png"); // 타겟파일(저장할 파일)

        long size = Files.size(from);
 
        FileChannel fileChannel_from = FileChannel.open(from);
        FileChannel fileChannel_to1 = FileChannel.open(to1,
                EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
        FileChannel fileChannel_to2 = FileChannel.open(to2,
                EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
 
        ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
        ByteBuffer directBuffer = ByteBuffer.allocateDirect((int) size);
 
        long start, end;
 
        // 넌 다이렉트 버퍼를 이용해 파일을 100번 복사
        start = System.nanoTime();
 
        for (int i = 0; i < 100; i++) {
            fileChannel_from.read(nonDirectBuffer);
            nonDirectBuffer.flip();
            fileChannel_to1.write(nonDirectBuffer);
            nonDirectBuffer.clear();
        }
 
        end = System.nanoTime();
        // 넌 다이렉트 버퍼를 이용해 이미지 파일을 100번 복사
        System.out.println("넌 다이렉트:\t" + (end - start) + " ns");
 

        // 다이렉트 버퍼를 이용해 이미지 파일을 100번 복사
        start = System.nanoTime();
 
        for (int i = 0; i < 100; i++) {
            fileChannel_from.read(directBuffer);
            directBuffer.flip();
            fileChannel_to2.write(directBuffer);
            directBuffer.clear();
        }
 
        end = System.nanoTime();
        // 다이렉트 버퍼를 이용해 이미지 파일을 100번 복사
        System.out.println("다이렉트\t: " + (end - start) + " ns");
 
        fileChannel_from.close();
        fileChannel_to1.close();
        fileChannel_to2.close();

        // 출력 결과: 다이렉트 버퍼가 더 빠름
        /*
        넌 다이렉트     : 5885000 ns
        다이렉트        : 2927300 ns
         */
    }
}
