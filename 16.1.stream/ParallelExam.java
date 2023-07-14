import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExam {
  public static void main(String[] args) {

    List<String> list = Arrays.asList("1", "2", "3", "$", "5");

    // 순차처리(싱글스레드)
    Stream<String> stream = list.stream();
    stream.forEach(name -> print(name));
        /*
        1 : main
        2 : main
        3 : main
        $ : main
        5 : main
         */
    stream.forEach(ParallelExam::print); // 메서드 참조로 표현하기
        /*
        1 : main
        2 : main
        3 : main
        $ : main
        5 : main
         */
    System.out.println();
    // 병렬처리
    Stream<String> parallStream = list.parallelStream();
    parallStream.forEach(ParallelExam::print); // 처리 내용을 개발자가 ParallelExam::print와 같은 메서드 참조로 제공
        /*
        3 : main
        1 : ForkJoinPool.commonPool-worker-2
        2 : ForkJoinPool.commonPool-worker-1
        $ : main
        5 : ForkJoinPool.commonPool-worker-2
         */
  }

  public static void print(String str) {
    System.out.println(str + " : " + Thread.currentThread().getName());
  }
}
