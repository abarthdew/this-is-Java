import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndReductionExam {
    public static void main(String[] args) {
        
        List<Student611> totalList = Arrays.asList(
            new Student611("홍길동", 10, Student611.Sex.MALE),
            new Student611("홍길동2", 12, Student611.Sex.FEMALE),
            new Student611("홍길동3", 10, Student611.Sex.MALE),
            new Student611("홍길동4", 12, Student611.Sex.FEMALE)
        );
        
        // 성별 별 평균점수
        Map<Student611.Sex, Double> mapBySex
            = totalList.stream()
                .collect(
                    Collectors.groupingBy(
                       Student611::getSex, // 무엇을 key로 할 것인가
                       Collectors.averagingDouble(Student611::getScore) // 무엇을 저장할 것이냐
                    )
                );
        System.out.println("남학생 평균 점수: " + mapBySex.get(Student611.Sex.MALE)); // 남학생 평균 점수: 10.0
        System.out.println("여학생 평균 점수: " + mapBySex.get(Student611.Sex.FEMALE)); // 여학생 평균 점수: 12.0

        // 성별 별 학생 이름 + ','
        Map<Student611.Sex, String> mapByName
            = totalList.stream()
                .collect(
                    Collectors.groupingBy(
                        Student611::getSex, // 무엇을 key로 할 것인가
                        Collectors.mapping( // 학생 이름 매핑
                            Student611::getName,
                            Collectors.joining(",")
                        )
                    )
                );
        System.out.println("남학생 전체 이름: " + mapByName.get(Student611.Sex.MALE)); // 남학생 전체 이름: 홍길동,홍길동3
        System.out.println("여학생 전체 이름: " + mapByName.get(Student611.Sex.FEMALE)); // 여학생 전체 이름: 홍길동2,홍길동4

    }
}
