import java.util.*;

public class HashMapExam {
  public static void main(String[] args) {

    Map<String, Integer> map = new HashMap<>();
    map.put("자바", 85);
    map.put("자바스크립트", 90);
    map.put("파이선", 80);
    map.put("자바", 95); // 중복된 키 저장 안 됨

    System.out.println(map.size()); // 3

    // 중복 키 중 어떤 게 저장되었는지 확인
    System.out.println(map.get("자바")); // 95
    // 이전의 값이 새로운 값으로 저장됨

    System.out.println();

    // 요소 가져오기 1: key set을 이용한 요소 가져오기
    Set<String> keySet = map.keySet(); // Map 컬렉션의 키값만 뽑아 저장
    Iterator<String> keyIter = keySet.iterator(); // 키의 반복자를 얻어냄
    while (keyIter.hasNext()) {
      String key = keyIter.next();
      Integer value = map.get(key);
      System.out.println(key + " / " + value);
            /*
            파이선 / 80
            자바 / 95
            자바스크립트 / 90
             */
    }

    // 객체 삭제
    map.remove("자바"); // "자바"가 key인 MapEntry가 제거됨
    System.out.println(map.size()); // 2

    // 요소 가져오기 2: entry set을 이용한 요소 가져오기 2
    Set<Map.Entry<String, Integer>> entrySet // Set에는 Map의 중첩 인터페이스 타입인 Map.Entry 객체가 저장됨
      = map.entrySet();
    Iterator<Map.Entry<String, Integer>> entryIter = entrySet.iterator();
    while (entryIter.hasNext()) {
      Map.Entry<String, Integer> entry = entryIter.next();
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + " / " + value);
            /*
            파이선 / 80
            자바스크립트 / 90
             */
    }

    // 전체 객체 삭제
    map.clear();
    System.out.println(map.size()); // 0

    // 동등객체 비교
    Map<Student, Integer> map2 = new HashMap<>();
    map2.put(new Student(1, "홍길동"), 95);
    map2.put(new Student(1, "홍길동"), 90);
    // new Student(1, "홍길동")는 서로 다른 객체지만, 학생 번호와 이름이 같으므로 동등객체

    System.out.println("총 Entry수 : " + map.size()); // 총 Entry수 : 0
    System.out.println(map2.get(new Student(1, "홍길동"))); // 90

  }
}

class Student {

  public int sno;
  public String name;

  public Student(int sno, String name) {
    this.sno = sno;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Student) {
      Student student = (Student) obj;
      return sno == student.sno && name.equals(student.name);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    // return sno + name.hashCode();
    return Objects.hash(sno, name); // 위 코드와 동일
  }

}