import java.util.Objects;

public class NullExam {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.requireNonNull(str1)); // 홍길동 // str1이 null 이 아니므로 매개 값을 리턴
        // System.out.println(Objects.requireNonNull(str2)); // 예외 발생

        // 예외 처리
        try {
            System.out.println(Objects.requireNonNull(str2)); 
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } // null
        
        // 예외 메세지 추가
        try {
            System.out.println(Objects.requireNonNull(str2, "이름이 없습니다"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } // 이름이 없습니다

        // 람다식을 사용해 예외 메세지 추가
        try {
            System.out.println(Objects.requireNonNull(str2, ()->"이름이 없습니다2"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } // 이름이 없습니다2

        System.out.println(Objects.isNull(str1)); // false
        System.out.println(Objects.isNull(str2)); // true
        System.out.println(Objects.nonNull(str1)); // true
        System.out.println(Objects.nonNull(str2)); // false
    }
}
