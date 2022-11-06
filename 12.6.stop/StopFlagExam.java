public class StopFlagExam {
    public static void main(String[] args) throws InterruptedException {
        
        PrintThread printThread = new PrintThread();
        printThread.start();

        Thread.sleep(1000);

        printThread.setStop(true);

        /*
        실행 중
        실행 중
        실행 중
        실행 중
        실행 중
        실행 중
        실행 중
        실행 중
        ....(반복)...
        (1초 뒤)
        자원 정리
        실행 종료
         */

    }
}
