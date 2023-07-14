import java.util.Arrays;
import java.util.List;

public class MaleStudent2Exam {
  public static void main(String[] args) {

    List<Student611> totalList = Arrays.asList(
      new Student611("홍길동", 10, Student611.Sex.MALE),
      new Student611("홍길동2", 6, Student611.Sex.FEMALE),
      new Student611("홍길동3", 10, Student611.Sex.MALE),
      new Student611("홍길동4", 6, Student611.Sex.FEMALE)
    );

    MaleStudent2 maleStudent
      = totalList.parallelStream()
      .filter(s -> s.getSex() == Student611.Sex.MALE)
      .collect(
        () -> new MaleStudent2(),
                /* (생성자 4개 만듦)
                [ForkJoinPool.commonPool-worker-2] MaleStudent()
                [main] MaleStudent()
                [ForkJoinPool.commonPool-worker-1] MaleStudent()
                [ForkJoinPool.commonPool-worker-3] MaleStudent()
                 */
        (r, t) -> r.accumulate(t),
                /* (전체 4명 중 남학생이 2명이므로 accumulate() 2번 호출)
                [main] accumulate() 
                [ForkJoinPool.commonPool-worker-3] accumulate()
                 */
        (r1, r2) -> r1.combine(r2)
                /* (전체 결합 3번)
                [main] combine()
                [ForkJoinPool.commonPool-worker-3] combine()
                [ForkJoinPool.commonPool-worker-3] combine()
                 */
      );
    maleStudent.getList().stream()
      .forEach(s -> System.out.println(s.getName()));
                /*
                홍길동
                홍길동3
                 */
  }
}


/* (전체 출력 내용)
[ForkJoinPool.commonPool-worker-2] MaleStudent()
[main] MaleStudent()
[ForkJoinPool.commonPool-worker-1] MaleStudent()
[ForkJoinPool.commonPool-worker-3] MaleStudent()
[main] accumulate()
[main] combine()
[ForkJoinPool.commonPool-worker-3] accumulate()
[ForkJoinPool.commonPool-worker-3] combine()
[ForkJoinPool.commonPool-worker-3] combine()
홍길동
홍길동3
 */