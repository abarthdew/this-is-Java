public class CalculatorExam {
  public static void main(String[] args) {

    double result1 = 10 * 10 * Math.PI; // Math.PI는 상수
    double result2 = 10 * 10 * Calculator.pi;
    int result3 = Calculator.plus(10, 5);
    int result4 = Calculator.minus(10, 5);

    System.out.println(result1); // 314.1592653589793
    System.out.println(result2); // 314.159
    System.out.println(result3); // 15
    System.out.println(result4); // 5

    Calculator cal = new Calculator();
    int result5 = cal.plus(1, 2); // 바람직하지 않은 예: 경고 밑줄 나타남
    System.out.println(result5); // 3
  }
}
