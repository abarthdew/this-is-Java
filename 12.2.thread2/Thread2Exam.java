public class Thread2Exam {
  public static void main(String[] args) throws InterruptedException { // main() 메서드는 JVM이 생성한 main 스레드에 의해 자동 실행됨

    Thread thread1 = new Thread2Task();
    thread1.start();

    // 띵 문자열을 5번 출력하는 작업
    for (int i = 1; i < 6; i++) {
      System.out.println("띵");
      ;
      Thread.sleep(500);
    }
        /*
        띵
        1
        띵
        2
        3
        띵
        4
        띵
        띵
        5
         */

    // 익명 객체 만들기
    Thread thread2 = new Thread() {
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
    };
    thread2.start();

  }
}
