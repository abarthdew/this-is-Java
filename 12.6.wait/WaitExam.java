public class WaitExam {
  public static void main(String[] args) {

    WorkObj workObj = new WorkObj(); // 공유객체 생성
    WaitA a = new WaitA(workObj);
    WaitB b = new WaitB(workObj);

    a.start();
    b.start();

    // 스레드a가 methodA()를 한 번 실행하고,
    // 스레드b가 methodB()를 한 번 실행하고, ... 번갈아서 실행하게 하기
        
        /* 실행 결과: 한 번씩 번갈아 실행됨
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
        WaitA의 methodA() 작업 실행
        WaitB의 methodB() 작업 실행
         */

  }
}
