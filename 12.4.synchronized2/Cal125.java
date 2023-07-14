public class Cal125 {

  private int memory;

  public int getMemory() {
    return memory;
  }

  public synchronized void setMemory(int memory) {
    this.memory = memory;
    try {
      Thread.sleep(2000);
      System.out.println(Thread.currentThread().getName() + ":" + this.memory);
    } catch (Exception e) {
    }
  }

}