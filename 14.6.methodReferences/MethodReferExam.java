import java.util.function.IntBinaryOperator;

public class MethodReferExam {
  public static void main(String[] args) {

    // 두 개의 int 값을 받아 int 값 정수를 리턴하기 때문에,
    // 함수적 인터페이스인 IntBinaryOperator와, Calculator146가 가지고 있는 메서드의 타입이 맞아 메서드 레퍼런스 사용 가능
    IntBinaryOperator operator;

    // 정적 메서드 참조
    operator = (x, y) -> Calculator146.staticMethod(x, y);
    System.out.println(operator.applyAsInt(1, 2)); // 3

    operator = Calculator146::staticMethod;
    System.out.println(operator.applyAsInt(3, 4)); // 7

    // 인스턴스 메서드 참조
    Calculator146 obj = new Calculator146();
    operator = (x, y) -> obj.instanceMethod(x, y);
    System.out.println(operator.applyAsInt(5, 6)); // 11

    operator = obj::instanceMethod;
    System.out.println(operator.applyAsInt(7, 8)); // 15

  }
}
