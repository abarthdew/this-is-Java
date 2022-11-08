import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteSubmit5Exam {
    public static void main(String[] args) throws InterruptedException {
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // execute()가 아닌 submit() 사용해 보기
        for (int i=0; i<10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("총 스레드 개수: " + poolSize + " / 작업 스레드 이름: " + threadName);
                    int value = Integer.parseInt("삼"); // 예외 발생 지점
                }
            };
            executorService.submit(runnable); // submit() 사용
            // submit() 으로 작업 큐에 작업을 저장하게 되면, 
            // 스레드는 작업을 처리하다 예외가 발생해도 종료되지 않음
            // -> 다음 작업을 작업 큐에서 가져와 계속 처리
            // 즉, 스레드를 계속해서 재사용함
            // execute() 보다 효율적인 방법
            Thread.sleep(10);

            /*
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2
             */
        }

        executorService.shutdown();

    }
}