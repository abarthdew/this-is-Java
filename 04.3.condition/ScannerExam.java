import java.util.Scanner;
// int, long과 같은 기본 타입이 아닌 클래스 타입이기 때문에, Scanner를 사용하기 위해 이 객체가 있는 패키지 위치를 명시해서 컴파일러에게 알려줘야 함.
// 컴파일러는 해당 객체를 찾아 변수를 선언하게 해 줌.

public class ScannerExam {
  public static void main(String[] args) {
    System.out.print("입력하세요: ");
    Scanner scanner = new Scanner(System.in); // 키보드로부터 문자열을 읽음
    // 입력하세요: 12345
    String inputStr = scanner.nextLine(); // 키보드로 입력한 문자열을, 엔터키를 누르기 직전까지 return해 줌
    System.out.println(inputStr); // 12345
  }
}
