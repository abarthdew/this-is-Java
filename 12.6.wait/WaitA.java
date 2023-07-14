public class WaitA extends Thread {
  private WorkObj workObj;

  public WaitA(WorkObj workObj) {
    this.workObj = workObj;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      workObj.methodA();
    }
  }
}
