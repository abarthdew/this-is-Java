import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorExam {
  public static void main(String[] args) {

    // Member146::new; 가 대입되는 건 같은데, 실제 실행되는 생성자는 다름

    Function<String, Member146> func1 = Member146::new;
    Member146 b1 = func1.apply("angel"); // Member(String id) 실행

    BiFunction<String, String, Member146> func2 = Member146::new;
    Member146 b2 = func2.apply("천사", "angel"); // Member(String name, String id) 실행

    // 생성자 참조 코드는 같아도, 매개변수가 어떻게 제공되느냐에 따라 어떤 생성자가 실행될지가 결정됨
  }
}

class Member146 {

  private String name;
  private String id;

  public Member146() {
    System.out.println("Member() 실행");
  }

  public Member146(String id) {
    System.out.println("Member(String id) 실행");
    this.id = id;
  }

  public Member146(String name, String id) {
    System.out.println("Member(String name, String id) 실행");
    this.name = name;
    this.id = id;
  }

}