import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExam {
    public static void main(String[] args) {
        
        ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");
        class Task implements Runnable { // 클래스로 직접 선언
            Result result;
            Task(Result result) {
                this.result = result;
            }
            @Override
            public void run() {
                // 1~10 까지의 합을 공유 객체 result에 저장하기
                int sum = 0;
                for (int i=0; i<=10; i++) {
                    sum += i;
                }
                result.addValue(sum);
            }
        };

        // 실제 작업을 만들어 스레드 풀에서 처리하도록 하기

        // 스레드들이 공유할 객체(외부 객체) result 생성
        Result result = new Result();

        // result 객체를 공유하는 두개의 작업을 정의
        Runnable task1 = new Task(result);
        Runnable task2 = new Task(result);

        // 두 작업을 스레드 풀의 작업 큐에 넣어 줌
        Future<Result> future1 = executorService.submit(task1, result);
        Future<Result> future2 = executorService.submit(task2, result);

        // 스레드가 task1, task2를 완료할 때까지 블로킹
        try {
            // future1.get(), future2.get()가 리턴하는 result는 같은 객체
            result = future1.get(); // [이 시점에서의 예상 값: 55] 하지만, 이 시점에서는 tesk1의 결과값만 누적이 된 상태
            result = future2.get(); // [이 시점에서의 예상 값: 55+55 = 110] 이 시점에서는 task2 결과값 까지 누적된 상태
            // task1, 2가 모두 완료된 시점
            System.out.println("처리 결과: " + result.accumValue); // task1, 2가 누적된 결과가 저장됨(110)
            System.out.println("작업 처리 완료");
        } catch (Exception e) {
            System.out.println("실행 예외 발생" + e.getMessage());
        }
        /* (출력 결과)
        작업 처리 요청
        처리 결과: 110
        작업 처리 완료
         */
    }
}

class Result { // 공유 객체
    int accumValue;
    synchronized void addValue(int value) { // 스레드 하나씩 사용할 수 있도록 동기화 메서드 처리
        accumValue += value;
    }
}
