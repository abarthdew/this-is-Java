import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {
  public static void main(String[] args) {

    Set<String> set = new HashSet<String>();
    set.add("java");
    set.add("jdbc");
    set.add("servlet");
    set.add("java"); // 중복 저장하지 않음
    set.add("ibatis");

    int size = set.size();
    System.out.println("총 객체수: " + size);

    Iterator<String> iter = set.iterator();
    while (iter.hasNext()) { // 가져올 게 있으면 true
      String element = iter.next(); // 집합에서 요소를 하나씩 가져옴
      System.out.println("\t" + element);
    }
        /*
        총 객체수: 4
            java   
            servlet
            ibatis 
            jdbc 
        */

    set.remove("jdbc");
    System.out.println("총 객체수: " + set.size());

    for (String element : set) { // 향상된 for문으로 집합에서 요소 꺼내오기
      System.out.println("\t" + element);
    }
        /*
        총 객체수: 3  
        java   
        servlet
        ibatis
        */

    set.clear(); // 모든 객체 제거
    if (set.isEmpty()) {
      System.out.println("비어있음"); // 비어있음
    }

    // 동등 객체 비교
    Set<Member> set2 = new HashSet<>();
    set2.add(new Member("홍길동", 30));
    set2.add(new Member("홍길동", 30));

    // 동등 객체이기 때문에 실제 저장되는 건 하나
    System.out.println(set2.size());  // 1

  }
}

class Member {

  public String name;
  public int age;

  public Member(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member) {
      Member member = (Member) obj;
      return member.name.equals(name) && member.age == age;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return name.hashCode() + age;
  }

}