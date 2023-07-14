import java.util.Objects;

public class ToStringExam {
  public static void main(String[] args) {
    String str1 = "홍길동";
    String str2 = null;

    System.out.println(Objects.toString(str1)); // 홍길동
    System.out.println(Objects.toString(str2)); // null

    System.out.println(Objects.toString(str2, "이름이 없습니다")); // 이름이 없습니다
  }
}
