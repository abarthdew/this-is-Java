import java.util.Arrays;

public class SortExam {
  public static void main(String[] args) {

    int[] scores = {99, 97, 98};
    Arrays.sort(scores);
    System.out.println(Arrays.toString(scores)); // [97, 98, 99]
    for (int score : scores) {
      System.out.println(score);
            /*
            97
            98
            99
             */
    }

    String[] names = {"홍길동", "김민수", "박동수"};
    Arrays.sort(names);
    for (int i = 0; i < names.length; i++) {
      System.out.println(names[i]);
            /*
            김민수
            박동수
            홍길동
             */
    }

    // SortMember클래스가 Comparable 인터페이스를 구현하지 않았을 경우
    SortMember m1 = new SortMember("홍길동");
    SortMember m2 = new SortMember("박동수");
    SortMember m3 = new SortMember("김민수");
    SortMember[] members = {m1, m2, m3};
    Arrays.sort(members);
    for (SortMember m : members) {
      System.out.println(m);
      // Exception in thread "main" java.lang.ClassCastException: SortMember cannot be cast to java.lang.Comparable
      // SortMember 객체를 Comparable 인터페이스 타입으로 캐스팅 할 수 없음
      // : SortMember 배열은 Comparable의 구현체들을 배열 요소로 가지고 있어야 함
      // : 즉, SortMember는 Comparable의 구현체여야 함
    }

    // SortMember클래스가 Comparable 인터페이스를 구현했을 경우
    for (int i = 0; i < members.length; i++) {
      System.out.println(members[i].name);
            /*
            김민수
            박동수
            홍길동
             */
    }
    // Arrays.sort(members); 를 올바로 사용하려면 members 배열 요소가 Comparable 인터페이스를 반드시 구현해야 함
  }
}
