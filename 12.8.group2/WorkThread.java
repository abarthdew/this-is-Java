public class WorkThread extends Thread {
    
    public WorkThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName); // 상위 스레드 생성자 호출
        // WorkThread 스레드는 ThreadGroup threadGroup 그룹에 포함됨
        // WorkThread 스레드의 이름은 String threadName가 됨
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + " 가 종료됨");
    }

}
