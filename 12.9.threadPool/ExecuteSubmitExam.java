import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteSubmitExam {
  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(2); // 최대 스레드 수는 2개

    // 결과값이 없는 작업 정의
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("작업 처리" + threadName); // 작업 내용
      }
    };

    executorService.execute(runnable);
    // execute() 메서드를 통해 작업 객체인 runnable 지정
    // -> 작업 큐에 runnable이 저장됨
    // -> 스레드 풀(ExecutorService executorService)의 스레드가 작업 큐에 저장된 runnable 객체를 처리함

    // (출력내용): 작업 처리pool-1-thread-1

    // 스레드 풀 종료
    executorService.shutdown(); // 작업 큐에 있는 작업들을 처리한 뒤 스레드풀 종료

  }
}