public class WorkObj {

    // synchronized 필수
    public synchronized void methodA() {
        // 아래 작업을 한 번 실행했다면,
        System.out.println("WaitA의 methodA() 작업 실행");
        notify(); // 현재 waiting된 스레드를 실행 대기로 만듦(스레드 a가 스레드 b를 실행 대기로 만듬)
        try {
            wait(); // 자기 자신은 wait()를 호출, 일시 정지로 만듦(스레드 a가 스레드 a를 일시 정지로 만듬)
        } catch (InterruptedException e) {} 
    }

    // synchronized 필수
    public synchronized void methodB() {
        System.out.println("WaitB의 methodB() 작업 실행");
        notify(); // 현재 waiting된 스레드를 실행 대기로 만듦(스레드 b가 스레드 a를 실행 대기로 만듬)
        try {
            wait(); // 자기 자신은 wait()를 호출, 일시 정지로 만듦(스레드 b가 스레드 b를 일시 정지로 만듬)
        } catch (InterruptedException e) {} 
    }
}
