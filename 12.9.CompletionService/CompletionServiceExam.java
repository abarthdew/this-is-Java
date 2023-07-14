import java.util.concurrent.*;

public class CompletionServiceExam {
  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors()
    );

    // 결과 값이 Integer이므로 타입 지정
    CompletionService<Integer> completionService // 인터페이스
      = new ExecutorCompletionService<Integer>(executorService); // 구현 클래스

    // 1. 작업 처리 요청
    // poll(), take()를 사용하려면 스레드 풀의 작업 큐에 작업을 저장하기 위해 submit() 메서드를 호출하는데,
    // executorService.submit() 이 아닌
    // completionService.submit()을 이용해야 함
    for (int i = 0; i < 3; i++) {
      completionService.submit(new Callable<Integer>() { // 작업 큐에 새로운 Callable 객체 3개를 저장
        @Override
        public Integer call() throws Exception {
          int sum = 0;
          for (int i = 1; i <= 10; i++) {
            sum += i;
          }
          return sum;
        }
      });
    }

    // 2. 처리 완료된 작업 확인
    executorService.submit(new Runnable() { // submit(): new Runnable 작업을 스레드 풀에서 처리를 하겠다는 의미 = 작업 큐에 넣어 스레드가 처리 하겠다는 의미
      // 왜 처리 완료된 작업을 확인하는 내용까지 스레드 풀에서 처리를 할까?
      @Override
      public void run() {
        while (true) {
          try {
            Future<Integer> future = completionService.take(); // -> 이 메서드를 사용하기 위해서임
            // take() 메서드는 블로킹이 됨
            // 완료된 작업이 있을 때마다 가져와서 처리(하나씩 처리하기 때문에 반복 호출해서 다음 완료된 작업을 가져올 수 있도록 함)
            // 즉, 작업이 완료된 순서대로 그 작업의 결과를 가져오는 future를 얻음
            int value = future.get(); // 완료된 작업의 결과를 얻음
            // get() 또한 블로킹 메서드지만 여기서는 블로킹 되지 않음
            // take()가 이미 완료된 작업을 가져오기 때문에 get()은 그 즉시 결과값을 리턴함(이미 완료된 작업이 나왔으므로 결과 값을 빨리 리턴해 줌)
            System.out.println("처리 결과: " + value); // 작업 큐에 들어간 순서대로 작업이 완료되는 것이 보장되진 않음
          } catch (Exception e) {
            break; // 예외 발생 시 반복문 빠져나옴
          }
        }
      }
    });

    // 프로그램이 너무 빨리 종료되면 1. 단계를 모두 완료하지 못한 채 끝날 수 있으므로 방지코드
    Thread.sleep(3000); // 1. 단계가 작업 큐에 들어가고 나서 스레드가 작업을 처리하려면 시간이 필요함
    // 즉, 1. 단계와 같이 작업 큐에 Callable를 저장했다고 해서 작업이 끝난 게 아니고,
    // 스레드가 이 작업을 가져와 처리할 시간이 필요하기 때문

    // 스레드 풀 shot down: 3초 내에 처리되지 않으면 스레드 풀 강제 종료
    executorService.shutdownNow();

        /* (출력 결과): 3개의 Callable 객체가 작업이 완료되어 다음과 같이 처리 결과가 나온 것을 확인할 수 있음
        처리 결과: 55 (몇 번째 생성된 Callable 객체인지 알 수 없음)
        처리 결과: 55
        처리 결과: 55
         */
  }
}