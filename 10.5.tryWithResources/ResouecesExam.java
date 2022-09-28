import java.io.IOException;

public class ResouecesExam {
    public static void main(String[] args) {
        
        try(FileInputStream fis = new FileInputStream("file.txt")) { // fis의 객체가 만들어지고 나서,
            fis.read(); // try 블록에서 fis 객체 사용
            // try 블록이 끝나면 자동적으로 close() 메서드 실행됨
        } catch(Exception e) {
            System.out.println("예외 발생");
        }
        /*
         file.txt을 읽습니다
        file.txt을 닫습니다
         */

        try(FileInputStream fis = new FileInputStream("file.txt")) { 
            fis.read(); 
            throw new Exception(); // 예외가 발생되면, 예외 발생 즉시 close() 자동 호출
        } catch(Exception e) {
            System.out.println("예외 발생"); // 그리고 그 후 예외 처리 코드 실행
        }
        /*
         file.txt을 읽습니다
        file.txt을 닫습니다
        예외 발생
         */
    }
}
