import java.util.function.Function;

public class FunctionAndThenExam {
  public static void main(String[] args) {

    Function<Member145, Address145> fA;
    Function<Address145, String> fB;
    Function<Member145, String> fAB; // 최종적으로 Member를 매개값으로 주면 String 결과값이 리턴되는 Function을 만들고 싶음

    // fA에서 Address를 얻고, 그 값을 fB에 매개값으로 제공해 String 결과값을 얻음
    fA = (m) -> m.getAddress();
    fB = (a) -> a.getCity();

    fAB = fA.andThen(fB);
    String city = fAB.apply(
      new Member145("홍길동", "hong", new Address145("한국", "서울")) // apply()에 Member 객체 제공
    );
    // 1. 먼저 fA가 Address 객체 리턴
    // 2. 1.을 fB의 매개값으로 제공, fB가 getCity()를 얻어내 이 값을 최종적으로 String으로 리턴
    System.out.println(city); // 서울

    fAB = fB.compose(fA);
    city = fAB.apply(
      new Member145("홍길동", "hong", new Address145("한국", "부산"))
    );
    System.out.println(city); // 부산

  }
}
