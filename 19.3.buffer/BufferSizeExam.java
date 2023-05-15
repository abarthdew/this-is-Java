import java.nio.ByteBuffer;

public class BufferSizeExam {
    public static void main(String[] args) {
        
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(200*1024*1024); // 200mb를 운영체제 메모리에 생성
        System.out.println("다이렉트 버퍼가 생성되었습니다.");

        ByteBuffer nonDirectBuffer = ByteBuffer.allocate(200*1024*1024); // jvm heap 메모리 영역에 nonDirectBuffer 생성
        System.out.println("넌다이렉트 버퍼가 생성되었습니다.");

    }
}
