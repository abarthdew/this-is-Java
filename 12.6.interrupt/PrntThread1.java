public class PrntThread1 extends Thread {
    
    @Override
    public void run() {
        System.out.println("실행 중");
        try {
            while(true) {
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {}
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }

}
