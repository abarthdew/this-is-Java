public class ThreadB extends Thread {

  public ThreadB() {
    setName("NAME_ThreadB");
  }

  @Override
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println(getName()); // getName(): 현재 생성된 스레드, 즉 ThreadA 객체의 인스턴스 메서드
    }
  }
}
