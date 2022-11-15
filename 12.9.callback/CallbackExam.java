import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExam {
    
    private ExecutorService executorService; // 스레드 풀 필드 정의

    public CallbackExam() {
        // 스레드 풀 생성
        executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() // CPU가 가진 코어의 수 만큼 스레드 풀 생성
        );
    }

    // 콜백 객체 생성(결과 타입 Integer, 첨부 객체는 사용하지 않음)
    private CompletionHandler<Integer, Void> callback 
        = new CompletionHandler<Integer,Void>() { // 익명 객체로 초기화
            @Override
            public void completed(Integer result, Void attachment) { // 완료 콜백: 스레드가 작업 처리 후 이 메서드 호출
                System.out.println("complete() 실행: " + result);
            }
            @Override
            public void failed(Throwable exc, Void attachment) { // 실패 콜백
                System.out.println("failed() 실행: " + exc.toString());
            }
        };

    // 작업을 생성하고 스레드 풀의 작업 큐에 작업을 넣는 기능을 수행하는 메서드 생성
    public void doWork(String x, String y) {
        // 작업 객체 생성
        Runnable task = new Runnable() { // 익명 객체 생성
            @Override
            public void run() {
                try {
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);
                    int result = intX + intY; // 결과값
                    callback.completed(result, null); // 성공 시 콜백 객체의 완료 메서드 호출
                } catch(NumberFormatException e) {
                    callback.failed(e, null); // 예외 시 콜백 객체의 실패 메서드 호출
                }
            }
        };
        // 스레드 풀 작업 큐에 작업을 넣음
        executorService.submit(task); // 작업 큐에 Runnable 객체가 들어감
    }

    public void finish() {
        executorService.shutdown();
    }

    public static void main(String[] args) {

        // CallbackExam 객체 생성 후 doWork() 실행
        CallbackExam exam = new CallbackExam();
        exam.doWork("3", "3");
        // 출력: complete() 실행: 6
        exam.doWork("3", "삼"); // 예외 발생 유도
        // 출력: failed() 실행: java.lang.NumberFormatException: For input string: "삼"

        // executorService 종료
        exam.finish();

    }

}