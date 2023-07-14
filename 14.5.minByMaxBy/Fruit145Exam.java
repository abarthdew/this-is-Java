import java.util.function.BinaryOperator;

public class Fruit145Exam {
  public static void main(String[] args) {

    BinaryOperator<Fruit145> binaryOperator; // 두 개의 Fruit145 객체를 받아 비교하는 BinaryOperator 함수적 인터페이스 변수 선언
    Fruit145 fruit; // 리턴값을 받기 위한 변수 Fruit145 선언

    binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price)); // 두 개의 정수를 비교
    fruit = binaryOperator.apply(
      new Fruit145("딸기", 6000),
      new Fruit145("수박", 7000)
    );
    System.out.println(fruit.name); // 딸기

    binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.price, f2.price)); // 두 개의 정수를 비교
    fruit = binaryOperator.apply(
      new Fruit145("딸기", 6000),
      new Fruit145("수박", 7000)
    );
    System.out.println(fruit.name); // 수박

  }
}
