import java.util.Objects;

public class DeepEqualsExam {
  public static void main(String[] args) {
    Integer o1 = 1000;
    Integer o2 = 1000;
    System.out.println(Objects.equals(o1, o2)); // true
    // o1.equals(o2)와 같은 작용을 함. 그러나, 이렇게 사용할 시 o1이 고정되어 매개값을 바꿀 수 없음
    System.out.println(Objects.equals(o1, null)); // false
    System.out.println(Objects.equals(null, null)); // true
    System.out.println(Objects.deepEquals(o1, o2)); // true // 배열이 아닐 경우, equals()로 작용

    System.out.println("=======");

    Integer[] arr1 = {1, 2};
    Integer[] arr2 = {1, 2};
    System.out.println(Objects.equals(arr1, arr2)); // false // 두 객체의 번지를 비교
    System.out.println(Objects.deepEquals(arr1, arr2)); // true // 두 객체가 배열일 경우, 번지가 달라도 두 객체 내 항목이 같으면 true 리턴
    System.out.println(Objects.deepEquals(arr1, null)); // false
    System.out.println(Objects.deepEquals(null, null)); // true
  }
}
