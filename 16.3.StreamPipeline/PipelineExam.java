import java.util.Arrays;
import java.util.List;

public class PipelineExam {
    public static void main(String[] args) {
        
        List<Member163> list = Arrays.asList(
            new Member163("홍길동", Member163.MALE, 30),
            new Member163("홍길동2", Member163.FEMALE, 32),
            new Member163("홍길동3", Member163.MALE, 35)
        );

        // 전체 회원 중 남자 회원만 뽑아 나이 평균을 구한다
        double age = list.stream() // 오리지날 스트림
        .filter(m -> m.getSex() == Member163.MALE) // 중간스트림1
        .mapToInt(a -> a.getAge()) // 중간스트림2
        .average() // 최종처리
        .getAsDouble(); // 리턴타입이 OptionalDouble이므로 double 값 얻기
        System.out.println("남자 평균 나이: " + age); // 남자 평균 나이: 32.5

    }
}