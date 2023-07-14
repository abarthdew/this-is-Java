public class PrntThread2 extends Thread {

  @Override
  public void run() {
    System.out.println("실행 중");
    while (true) {
      if (Thread.interrupted()) {
        // if (isInterrupted()) { // Thread 에게서 상속받은 인스턴스 메서드도 사용 가능
        break;
      }
    }
    System.out.println("자원 정리");
    System.out.println("실행 종료");
  }

}
