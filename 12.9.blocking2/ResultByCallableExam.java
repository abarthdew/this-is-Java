import java.util.concurrent.*;

public class ResultByCallableExam {
  public static void main(String[] args) {

    // 스레드 풀
    ExecutorService executorService = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors() // 현재 pc 코어 수 리턴
    );

    System.out.println("작업 처리 요청!");
    Callable<Integer> task = new Callable<Integer>() { // 리턴값이 있는 작업이므로 Callable
      @Override
      public Integer call() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
          sum += i;
        }
        return sum;
      }
    };

    Future<Integer> future // 나중에 get() 메서드로 얻을 수 있는 결과값
      = executorService.submit(task);

    try {
      int sum = future.get(); // 블로킹: call()이 다 완료될 때까지 기다림
      System.out.println("결과: " + sum + " 작업 처리 완료!");

    } catch (InterruptedException e) {
      System.out.println("예외 발생: " + e.getMessage());

    } catch (ExecutionException e) {
      System.out.println("예외 발생: " + e.getMessage());
    }

    executorService.shutdown();

        /* (출력결과)
        작업 처리 요청!
        결과: 45 작업 처리 완료!
         */
  }
}