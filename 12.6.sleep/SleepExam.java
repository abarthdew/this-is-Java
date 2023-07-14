public class SleepExam {
  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 10; i++) { // main 스레드가 for 문 실행
      System.out.println(i);
      Thread.sleep(3000); // main 스레드를 3초 동안 일시정지 상태로 만듦
      // 3초 후, 다시 실행 대기 -> for 문 실행
    }

  }
}
