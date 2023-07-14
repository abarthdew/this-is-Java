public class ThreadExam {
  public static void main(String[] args) throws InterruptedException { // main() 메서드는 JVM이 생성한 main 스레드에 의해 자동 실행됨

    // 두 개의 작업을 하는 코드 작성
    // 1~5 까지 출력하는 작업

    // 1. 번째 방법
    Runnable task1 = new ThreadTask();
    Thread thread1 = new Thread(task1);
    thread1.start();

    // 2. 번째 방법
    Thread thread2 = new Thread(new Runnable() {
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
    });
    thread2.start();

    // 3. 번째 방법
    Thread thread3 = new Thread(() -> {
      for (int i = 1; i < 6; i++) {
        System.out.println(i);
        ;
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    thread3.start();

    // 띵 문자열을 5번 출력하는 작업
    for (int i = 1; i < 6; i++) {
      System.out.println("띵");
      ;
      Thread.sleep(500);
    }

        /*
        1
        1
        띵
        1
        2
        2
        2
        띵
        3
        3
        띵
        3
        4
        4
        4
        띵
        5
        5
        띵
        5
         */

  }
}
