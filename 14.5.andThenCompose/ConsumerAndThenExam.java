import java.util.function.Consumer;

public class ConsumerAndThenExam {
  public static void main(String[] args) {

    Consumer<Member145> cA = (m) -> {
      System.out.println("consumerA: " + m.getName());
    };

    Consumer<Member145> cB = (m) -> {
      System.out.println("consumerB: " + m.getId());
    };

    Consumer<Member145> cAB = cA.andThen(cB);
    cAB.accept(new Member145("홍길동", "hong", null));
        /* (출력결과)
        consumerA: 홍길동
        consumerB: hong
         */

    // cA가 리턴값이 있으면 그걸 받아 cB에 제공될 텐데, Consumer는 리턴값이 없는 함수적 인터페이스므로 단순히 실행 순서만 정해짐

  }
}
