import java.util.Arrays;
import java.util.List;

public class MapExam {
    public static void main(String[] args) {
        
        List<Student161> list = Arrays.asList(
            new Student161("홍길동", 10),
            new Student161("홍길동2", 20),
            new Student161("홍길동3", 30)
        );

        list.stream()
            // .mapToInt(s -> s.getScore()) // Student 객체를 정수로 매핑하는 새로운 스트림 만들기
            .mapToInt(Student161::getScore) // 메서드 참조
            .forEach(score -> System.out.println(score)); // 최종 처리
    }
}
