import java.util.Arrays;
import java.util.List;

public class MaleStudentExam {
    public static void main(String[] args) {
        
        List<Student611> totalList = Arrays.asList(
            new Student611("홍길동", 10, Student611.Sex.MALE),
            new Student611("홍길동2", 6, Student611.Sex.FEMALE),
            new Student611("홍길동3", 10, Student611.Sex.MALE),
            new Student611("홍길동4", 6, Student611.Sex.FEMALE)
        );

        // 남학생만 필터링해 사용자 정의 컨테이너 객체인 MaleStudent에 수집하기
        MaleStudent maleStudent // collect() 가 리턴하는 타입
         = totalList.stream() // 전체 스트림 얻기
            .filter(s->s.getSex()==Student611.Sex.MALE)
            .collect(
                () -> new MaleStudent(), // MaleStudent라는 사용자 정의 컨테이너를 생성해서 리턴
                (r, t) -> r.accumulate(t), // 사용자 정의 컨테이너에 누적시키는 BiConsumer 생성
                    /* (출력)
                    [main] MaleStudent()
                    */
                // r: MaleStudent(사용자 정의 컨테이너)
                // t: 요소(필터링 된 요소가 하나씩 들어 옴)
                // 컨테이너(r)에 요소(t)를 누적하기 위해 r 내 accumulate() 메서드 호출, t를 매개값으로 대입
                    /* (출력: 필터링 요소가 2개기 때문에 호출 시 2번 출력됨)
                    [main] accumulate()
                    [main] accumulate()
                    */
                (r1, r2) -> r1.combine(r2) // 싱글 스레드에서 사용되지 않지만 작성하지 않으면 에러 나므로 작성만 함
                // 병렬 처리에서 컨테이너를 결합하는 역할: r1, r2 컨테이너 2개를 매개값으로 받아 r2로 결합
            );
            maleStudent.getList().stream()
                .forEach(s->System.out.println(s.getName()));
                /*
                홍길동
                홍길동3
                */
    }
}
