import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExam {
  private static List<Student145> list = Arrays.asList(
    new Student145("홍길동", 90, 85),
    new Student145("홍길동2", 95, 93)
  );

  public static void printString(Function<Student145, String> function) { // (Function<Student, String> function): Student를 매개값, String을 리턴값으로 하는 함수적 인터페이스 타입으로 매개변수 선언
    // 이 인터페이스에 구현 객체를 대입해 줘야 함
    // 호출 시 람다식으로 익명 구현 객체를 만들어 대입할 수 있음
    for (Student145 student : list) {
      System.out.print(function.apply(student) + " "); // apply()는 Student 타입으로 받은 student를 String으로 리턴함
      // 무슨 값이 리턴되는지는 printStirng() 호출 시 매개값으로 넘긴 람다식에 따라 달라짐
    }
    System.out.println(); // 개행
  }

  public static void printInt(ToIntFunction<Student145> function) {
    for (Student145 student : list) {
      System.out.print(function.applyAsInt(student) + " "); // 매개값을 정수값 int로 리턴
    }
    System.out.println(); // 개행
  }

  public static double avg(ToIntFunction<Student145> function) {
    int sum = 0;
    for (Student145 student : list) {
      sum += function.applyAsInt(student);
    }
    double avg = sum / list.size();
    return avg;
  }
  // 1. avg()는 함수적 인터페이스인 ToIntFunction<Student145> 타입으로 매개변수가 선언되어 있다
  // 2. 때문에, 매개변수로 t -> t.getEngScore()와 같은 람다식을 받을 수 있다
  // 3. 이 값을 applyAsInt()를 이용해 int 값으로 변환시킨다
  // 4. 변환된 값을 평균내고 리턴한다
  // 5. 학생 객체를 아래와 같이 어떤 int로 매핑했느냐에 따라,
  // t -> t.getEngScore()
  // t -> t.getMathSocre()
  // 영어 점수, 또는 수학 점수가 결과로 나올 수 있다

  public static void main(String[] args) {

    // 학생 이름
    printString(t -> t.getName()); // 홍길동 홍길동2
    // 매개값으로 구현 객체 넣음

    // 영어 점수
    printInt(t -> t.getEngScore()); // 90 95

    // 수학 점수
    printInt(t -> t.getMathSocre()); // 85 93

    // 평균 점수
    double engAvg = avg(t -> t.getEngScore());
    System.out.println(engAvg); // 92.0

    double mathAvg = avg(t -> t.getMathSocre());
    System.out.println(mathAvg); // 89.0

  }
}
