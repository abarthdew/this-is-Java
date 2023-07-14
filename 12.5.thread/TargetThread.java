public class TargetThread extends Thread {

  @Override
  public void run() { // 스레드가 실행하게 되면 run() 메서드가 실행됨
    for (long i = 0; i < 1000000000; i++) {
    } // 1억 번 반복

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
    } // 1.5초 동안 일시정지

    for (int i = 0; i < 1000000000; i++) {
    }
  }

}