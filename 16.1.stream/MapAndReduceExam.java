import java.util.Arrays;
import java.util.List;

public class MapAndReduceExam {
    public static void main(String[] args) {
        
        List<Student161> list = Arrays.asList(
            new Student161("홍길동", 10),
            new Student161("홍길동2", 20),
            new Student161("홍길동3", 30)
        );
        double avg = list.stream()
            // .mapToInt(s -> s.getScore()) // 1. 점수를 얻어 새로운 스트림을 만듬
            .mapToInt(Student161::getScore) // 메서드 참조    
            .average() // 2. 평균을 구하는 새로운 스트림을 만듬
            .getAsDouble() // 3. double 타입으로 최종 값 받음
        ;
        System.out.println(avg); // 20.0

    }
}
