public class DaemonExam {
    public static void main(String[] args) {
        
        AutoSaveThread a = new AutoSaveThread();
        a.setDaemon(true);
        a.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        System.out.println("메인 스레드 종료");
        /*
        작업 내용을 저장
        작업 내용을 저장
        메인 스레드 종료
        (3초 후 main 스레드가 종료되면 auto 스레드도 종료)
         */
    }
}
