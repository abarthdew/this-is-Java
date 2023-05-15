import java.nio.ByteOrder;

public class ComputerByteOrderExam {
    public static void main(String[] args) {
        
        System.out.println("운영체제 종류: " + System.getProperty("os.name")); // 운영체제 종류: Windows 10
        System.out.println("네이티브의 바이트 해석 순서: " + ByteOrder.nativeOrder()); // 네이티브의 바이트 해석 순서: LITTLE_ENDIAN

    }
}
