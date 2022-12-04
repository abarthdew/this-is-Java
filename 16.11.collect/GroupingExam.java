import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExam {
    public static void main(String[] args) {
        
        List<Student611> totalList = Arrays.asList(
            new Student611("홍길동", 10, Student611.Sex.MALE, Student611.City.Seoul),
            new Student611("홍길동2", 6, Student611.Sex.FEMALE, Student611.City.Pusan),
            new Student611("홍길동3", 10, Student611.Sex.MALE, Student611.City.Pusan),
            new Student611("홍길동4", 6, Student611.Sex.FEMALE, Student611.City.Seoul)
        );
        Map<Student611.Sex, List<Student611>> mapBySex
            = totalList.stream()
                .collect(Collectors.groupingBy(Student611::getSex)); // key: Student611::getSex
        System.out.println("남학생: ");
        mapBySex.get(Student611.Sex.MALE).stream()
            .forEach(s->System.out.println(s.getName()));
            /*
            남학생: 
            홍길동
            홍길동3
             */

        System.out.println("여학생: ");
        mapBySex.get(Student611.Sex.FEMALE).stream()
            .forEach(s->System.out.println(s.getName()));
            /*
            여학생:
            홍길동2
            홍길동4
             */

        Map<Student611.City, List<String>> mapByCity
            = totalList.stream()       
                .collect(
                    Collectors.groupingBy(
                        // 1. 키로 사용할 것(Function 함수적 인터페이스의 익명 구현 객체)
                        Student611::getCity,
                        // 2. 값으로 저장할 실제 요소(학생 객체 -> [매핑] -> 학생 객체의 이름)
                        Collectors.mapping(
                            Student611::getName, // 학생 객체를 어떤 요소로 매핑할 것이냐(학생 이름)
                            Collectors.toList() // 이름을 어떤 컬렉션에 넣을 것이냐(List)
                        ) 
                    )
                );
        
        System.out.println("서울: ");        
        mapByCity.get(Student611.City.Seoul).stream()
            .forEach(name->System.out.println(name));
            /*
            서울:
            홍길동
            홍길동4
             */

        System.out.println("부산: ");        
        mapByCity.get(Student611.City.Pusan).stream()
            .forEach(name->System.out.println(name));
            /*
            부산:
            홍길동2
            홍길동3
             */
    
    }
}
