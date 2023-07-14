import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteSubmit4Exam {
  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    // 예외 발생시켜 보기
    for (int i = 0; i < 10; i++) {
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
      executorService.execute(runnable);
      Thread.sleep(10);
            /*
            총 스레드 개수: 1 / 작업 스레드 이름: pool-1-thread-1
            Exception in thread "pool-1-thread-1" java.lang.NumberFormatException: For input string: "삼"
                    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                    at java.lang.Integer.parseInt(Integer.java:580) 
                    at java.lang.Integer.parseInt(Integer.java:615) 
                    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                    at java.lang.Thread.run(Thread.java:748)        
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-3
            Exception in thread "pool-1-thread-3" java.lang.NumberFormatException: For input string: "삼"
                    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                    at java.lang.Integer.parseInt(Integer.java:580) 
                    at java.lang.Integer.parseInt(Integer.java:615) 
                    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                    at java.lang.Thread.run(Thread.java:748)        
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-2
            Exception in thread "pool-1-thread-2" java.lang.NumberFormatException: For input string: "삼"
                    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                    at java.lang.Integer.parseInt(Integer.java:580) 
                    at java.lang.Integer.parseInt(Integer.java:615) 
                    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                    at java.lang.Thread.run(Thread.java:748)        
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-4   
            Exception in thread "pool-1-thread-4" java.lang.NumberFormatException: For input string: "삼"
                    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                    at java.lang.Integer.parseInt(Integer.java:580) 
                    at java.lang.Integer.parseInt(Integer.java:615) 
                    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-5
                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                    at java.lang.Thread.run(Thread.java:748)        
            Exception in thread "pool-1-thread-5" java.lang.NumberFormatException: For input string: "삼"
                    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                    at java.lang.Integer.parseInt(Integer.java:580) 
                    at java.lang.Integer.parseInt(Integer.java:615) 
                    at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-6
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)        
            Exception in thread "pool-1-thread-6" java.lang.NumberFormatException: For input string: "삼"
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580) 
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-7   
                at java.lang.Integer.parseInt(Integer.java:615) 
                at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)        
            Exception in thread "pool-1-thread-7" java.lang.NumberFormatException: For input string: "삼"
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580) 
                at java.lang.Integer.parseInt(Integer.java:615)
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-8   
                at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-9   
                at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)        
            총 스레드 개수: 2 / 작업 스레드 이름: pool-1-thread-10
            Exception in thread "pool-1-thread-9" 
            Exception in thread "pool-1-thread-8" java.lang.NumberFormatException: For input string: "삼"
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580)
                at java.lang.Integer.parseInt(Integer.java:615) 
                at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)        
            java.lang.NumberFormatException: For input string: "삼" 
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580) 
                at java.lang.Integer.parseInt(Integer.java:615) 
                at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)        
            Exception in thread "pool-1-thread-10" java.lang.NumberFormatException: For input string: "삼"
                at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.lang.Integer.parseInt(Integer.java:580) 
                at java.lang.Integer.parseInt(Integer.java:615) 
                at ExecuteSubmit4Exam$1.run(ExecuteSubmit4Exam.java:19)
                at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
                at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
                at java.lang.Thread.run(Thread.java:748)    
             */
    }

    executorService.shutdown();

  }
}