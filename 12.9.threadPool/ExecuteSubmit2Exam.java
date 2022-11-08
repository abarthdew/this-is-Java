import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteSubmit2Exam {
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 10개의 작업을 만들어 준다 -> executorService의 스레드 2개가 10개의 runnable 객체를 처리함
        for (int i=0; i<10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("작업 처리" + threadName);
                }
            };
            executorService.execute(runnable);
            /*
            작업 처리pool-1-thread-2
            작업 처리pool-1-thread-1
            작업 처리pool-1-thread-1
            작업 처리pool-1-thread-2
            작업 처리pool-1-thread-2
            작업 처리pool-1-thread-1
            작업 처리pool-1-thread-1
            작업 처리pool-1-thread-1
            작업 처리pool-1-thread-2
            작업 처리pool-1-thread-1
             */
        }


        executorService.shutdown();

    }
}