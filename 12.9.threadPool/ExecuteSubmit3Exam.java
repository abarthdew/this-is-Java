import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteSubmit3Exam {
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 현재 풀에 있는 스레드 수 얻기
        for (int i=0; i<10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService; // 총 스레드 개수 출력하기
                    int poolSize = threadPoolExecutor.getPoolSize(); // 현재 풀에 있는 스레드 수 얻기
                    String threadName = Thread.currentThread().getName();
                    System.out.println("총 스레드 개수: " + poolSize + " / 작업 스레드 이름: " + threadName);
                }
            };
            executorService.execute(runnable);
            /*
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2   
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-1
             */
        }


        executorService.shutdown();

    }
}