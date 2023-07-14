import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListExam {
  public static void main(String[] args) {

    List<Student611> totalList = Arrays.asList(
      new Student611("홍길동", 10, Student611.Sex.MALE),
      new Student611("홍길동2", 6, Student611.Sex.FEMALE),
      new Student611("홍길동3", 10, Student611.Sex.MALE),
      new Student611("홍길동4", 6, Student611.Sex.FEMALE)
    );

    // 남학생들만 묶어 List 생성
    List<Student611> maleList // collect(Collectors.toList())가 리턴하는 타입
      = totalList.stream()
      .filter(s -> s.getSex() == Student611.Sex.MALE)
      .collect(Collectors.toList());

    maleList.stream()
      .forEach(s -> System.out.println(s.getName()));
            /*
            홍길동
            홍길동3
             */

    System.out.println();

    // 여학생들만 묶어 HashSet 생성
    Set<Student611> femaleSet
      = totalList.stream() // 오리지널 스트림 생성
      .filter(s -> s.getSex() == Student611.Sex.FEMALE) // 필터링
      .collect(Collectors.toCollection(HashSet::new)); // HashSet에 수집
    // (HashSet::new): Suppler가 HashSet을 생성하도록 함

    femaleSet.stream()
      .forEach(s -> System.out.println(s.getName()));
            /*
            홍길동4
            홍길동2
                */
  }
}