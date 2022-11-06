public class InterruptExam {
    public static void main(String[] args) {
        
        // 1. 불안전한 종료: interrupt 예외를 발생시켜 스레드 중지하는 방법
        Thread thread1 = new PrntThread1();
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {} 

        // 1초 뒤 스레드 중지
        thread1.interrupt();
        /*
        실행 중
        자원 정리
        실행 종료
         */
        
        
        // 2. 안전한 종료: Thread.interrupted()를 사용해 스레드를 중지하는 방법
        Thread thread2 = new PrntThread2();
        thread2.start();
    
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {} 

        // 1초 뒤 스레드 중지
        thread2.interrupt();
        /*
        실행 중
        자원 정리
        실행 종료
         */

    }
}
