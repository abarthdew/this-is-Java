public class ThreadTask implements Runnable {
  @Override
  public void run() {
    for (int i = 1; i < 6; i++) {
      System.out.println(i);
      ;
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
