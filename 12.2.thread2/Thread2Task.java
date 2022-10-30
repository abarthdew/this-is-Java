public class Thread2Task extends Thread {
    // 하위 클래스로 새로운 스레드 만들기
    @Override
    public void run() {
        for (int i=1; i<6; i++) {
            System.out.println(i);;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
