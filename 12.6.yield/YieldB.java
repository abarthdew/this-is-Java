public class YieldB extends Thread {
  public boolean stop = false;
  public boolean work = true;

  @Override
  public void run() {
    while (!stop) {
      if (work) {
        System.out.println("YieldB의 작업 내용");
      } else {
        Thread.yield();
      }
    }
    System.out.println("YieldB 종료");
  }
}
