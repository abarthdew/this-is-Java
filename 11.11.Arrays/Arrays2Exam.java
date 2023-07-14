import java.util.Arrays;

public class Arrays2Exam {
  public static void main(String[] args) {

    int[][] original = {{1, 2}, {3, 4}};

    // 얕은 복사 후 비교
    int[][] clone1 = Arrays.copyOf(original, original.length);
    System.out.println(original.equals(clone1)); // false // 배열 번지 비교
    System.out.println(Arrays.equals(original, clone1)); // true // 1차 배열 항목값 비교
    System.out.println(Arrays.deepEquals(original, clone1)); // true // 중첩 배열 항목값 비교

    // 깊은 복사 후 비교
    int[][] clone2 = Arrays.copyOf(original, original.length);
    clone2[0] = Arrays.copyOf(original[0], original[0].length);
    clone2[1] = Arrays.copyOf(original[1], original[1].length);
    System.out.println(original.equals(clone2)); // false // 배열 번지 비교
    System.out.println(Arrays.equals(original, clone2)); // false // 1차 배열 항목값 비교
    System.out.println(Arrays.deepEquals(original, clone2)); //true // 중첩 배열 항목값 비교


  }
}
