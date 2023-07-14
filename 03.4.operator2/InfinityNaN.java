public class InfinityNaN {
  public static void main(String[] args) {
    int x = 5;
    double y = 0.0;

    double z = 5 / y;
    System.out.println(z); // Infinity
    System.out.println(Double.isInfinite(z)); // true

    double n = 5 % y;
    System.out.println(n); // NaN
    System.out.println(Double.isNaN(n)); // true
    System.out.println(z + 2); // Infinity

    if (Double.isInfinite(z) || Double.isNaN(z)) {
      System.out.println("값 산출 불가");
    } else {
      System.out.println(z + 2);
    }
    // 값 산출 불가

    int x2 = 5;
    int y2 = 0;
    int z2 = x2 / y2;
    System.out.println(z2); // 예외 발생: Exception in thread "main" java.lang.ArithmeticException: / by zero
  }
}