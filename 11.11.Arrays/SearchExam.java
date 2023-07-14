import java.util.Arrays;

public class SearchExam {
  public static void main(String[] args) {

    // 숫자 검색
    int[] scores = {99, 97, 98};
    int index = Arrays.binarySearch(scores, 99);
    System.out.println("찾은 인덱스: " + index); // -4

    Arrays.sort(scores); // binarySearch를 사용하기 전에 반드시 정렬부터 해야 함
    for (int s : scores) {
      System.out.println(s);
            /*
            97
            98
            99
             */
    }
    index = Arrays.binarySearch(scores, 99);
    System.out.println("찾은 인덱스: " + index); // 2 // [97, 98, 99]의 2번째

    // 문자열 검색
    String[] names = {"홍길동", "김민수", "박동수"};
    Arrays.sort(names);
    for (String n : names) {
      System.out.println(n);
            /*
            김민수
            박동수
            홍길동
             */
    }
    index = Arrays.binarySearch(names, "홍길동");
    System.out.println("찾은 인덱스: " + index); // 2

    // 사용자 정의 배열 검색
    SortMember m1 = new SortMember("홍길동");
    SortMember m2 = new SortMember("박동수");
    SortMember m3 = new SortMember("김민수");
    SortMember[] members = {m1, m2, m3};
    Arrays.sort(members);
    for (SortMember m : members) {
      System.out.println(m.name);
            /*
            김민수
            박동수
            홍길동
             */
    }
    index = Arrays.binarySearch(members, m1);
    System.out.println("찾은 인덱스: " + index); // 2
  }
}
