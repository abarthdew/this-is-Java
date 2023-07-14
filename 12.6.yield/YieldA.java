public class YieldA extends Thread {
  public boolean stop = false;
  public boolean work = true;

  @Override
  public void run() {
    while (!stop) {
      if (work) {
        System.out.println("YieldA의 작업 내용");
      } else {
        Thread.yield();
        // YieldA 스레드는 실행 대기 상태로 변경, 다른 스레드가 실행할 수 있도록 양보
      }
    }
    System.out.println("YieldA 종료");
  }
}
