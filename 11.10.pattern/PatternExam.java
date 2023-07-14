import java.util.regex.Pattern;

public class PatternExam {
  public static void main(String[] args) {
    String regExp = "(02|010)-\\d{3,4}-\\d{4}";
    String data = "010-123-4567";
    boolean result = Pattern.matches(regExp, data);
    System.out.println(result); // true

    regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
    data = "angel@naver.co.kr";
    result = Pattern.matches(regExp, data);
    System.out.println(result); // true
    data = "angel@naver.com";
    result = Pattern.matches(regExp, data);
    System.out.println(result); // true
  }
}