import java.io.IOException;

public class WhileExam {
    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.print("입력하세요: ");
            int keyCode = System.in.read();
            System.out.println(keyCode);
            // 1을 입력하고 엔터를 쳤을 때
            /*
             1 (입력값)
            49 (1에 대한 키코드값)
            13 (캐리지리턴-엔터키)
            10 (라인피드-엔터키)
             */
        }
    }
}