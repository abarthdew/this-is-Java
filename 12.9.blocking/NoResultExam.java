import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 리턴값이 없는 작업을 스레드에서 처리하고, 작업 처리 완료 통보를 받는 예제
public class NoResultExam {
    public static void main(String[] args) {
        
        // 스레드 풀 생성: 현재 pc의 코어 수 만큼 스레드 사용하기
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() // 현재 pc 코어 수 리턴
        );

        System.out.println("작업 처리 요청!");
        // 작업 처리 요청을 위해 작업 객체 생성
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 스레드 풀의 스레드가 처리할 내용 작성
                int sum = 0;
                for (int i=0; i<10; i++) {
                    sum += i;
                }
                System.out.println(sum);
            }
        };

        // 작업 객체를 스레드 풀의 작업 큐에 저장
        Future future // 결과값이 아님
            // 작업 객체(runnable)를 스레드가 처리하지 않아도 submit()은 Future를 리턴함
            = executorService.submit(runnable); // 리턴값이 없는 작업이므로 submit(Runnable task) 메서드 사용

        try {

            // [[get()은 run()이 실행되고 종료될 때까지 기다려주는 메서드]]
            // : ui 스레드에서 호출하지 않는 것이 중요!
            // : 여기서 get()을 호출한 스레드는 main 스레드이기 때문에 상관없음

            future.get();// future를 통해 get() 메서드를 호출하면 스레드가 이 작업을 완료할 때까지 기다렸다가 결과값을 리턴시켜 줌
            // 작업이 완료될 때 까지만 블로킹됨(run()이 완료될 때 까지 블로킹) -> 작업 완료 후 null 리턴  

            System.out.println("작업 처리 완료!"); // get()이 정상적으로 결과값(null)을 리턴하게 되면, 작업 처리가 완료된 것

        } catch (InterruptedException e) { // 스레드가 interrupt 되었을 때
            System.out.println("예외 발생: " + e.getMessage());

        } catch (ExecutionException e) { // 스레드가 실행하는 코드에서 예외가 발생했을 때
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        // 애플리케이션 종료 시, 스레드 풀도 종료하는 게 좋음
        executorService.shutdown(); // 작업 큐에 있는 작업들을 스레드가 다 처리한 경우 executorService 종료

        /* (출력결과)
        작업 처리 요청!
        45
        작업 처리 완료!
         */
    }
}