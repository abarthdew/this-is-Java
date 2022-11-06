public class StatePrintThread extends Thread {
    // 1. StatePrintThread는 targetThread의 상태를 계속해서 출력하는 스레드
    
    private Thread targetThread;

    public StatePrintThread (Thread targetThread) { // 2. 생성 시 targetThread의 객체를 받아 필드에 저장
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while (true) {
            // 3. StatePrintThread 실행 시, targetThread의 상태를 얻어냄
            Thread.State state = targetThread.getState(); // Thread.State: 스레드의 상태를 얻기 위해 Thread의 State 열거타입으로 state 로컬 변수 선언
            // 4. 얻어 낸 targetThread의 상태를 출력
            System.out.println("타겟 스레드 상태: " + state);
            // 5. targetThread 상태가 NEW가 되면(처음 만들어졌으면) 이 스레드를 start() 시킴 -> targetThread의 run() 메서드 실행
            if (state == Thread.State.NEW) { // 스레드 상태가 new 상태라면
                targetThread.start();
            }
            // 6. statePrintThread는 0.5초 주기로 반복문을 돌며 계속 targetThread의 상태를 출력함
            // 7. 그러다 targetThread가 종료되면, while 문을 빠져나옴
            if (state == Thread.State.TERMINATED) { // 스레드가 종료되었을 시
                break; // 빠져나옴
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {} // 너무 빨리 실행되는 것을 방지하기 위해 쉬면서 반복
        }
    }
}
