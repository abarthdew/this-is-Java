import java.util.Arrays;

public class LoopingExam {
  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5};

    // peek()마지막에 호출한 경우
    Arrays.stream(arr)
      .filter(a -> a % 2 == 0)
      .peek(n -> System.out.println(n)); // 동작하지 않음

    // 최종 처리 메서드를 마지막에 호출한 경우
    int total = Arrays.stream(arr)
      .filter(a -> a % 2 == 0)
      .peek(n -> System.out.print(n + ",")) // 2,4,
      .sum();
    System.out.println("총합: " + total); // 총합: 6

    // forEach()를 마지막에 호출한 경우
    Arrays.stream(arr)
      .filter(a -> a % 2 == 0)
      .forEach(n -> System.out.print(n + ",")); // 동작함 // 2,4,
  }
}
