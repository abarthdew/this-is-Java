public class ThreadStateExam {
  public static void main(String[] args) {

    StatePrintThread StatePrintThread = new StatePrintThread(new TargetThread());
    StatePrintThread.start(); // statePrintThread의 run() 메서드 호출

        /*
        타겟 스레드 상태: NEW 
        타겟 스레드 상태: RUNNABLE 
        타겟 스레드 상태: RUNNABLE 
        타겟 스레드 상태: RUNNABLE
        타겟 스레드 상태: TIMED_WAITING
        타겟 스레드 상태: TIMED_WAITING
        타겟 스레드 상태: TIMED_WAITING
        타겟 스레드 상태: RUNNABLE
        타겟 스레드 상태: RUNNABLE
        타겟 스레드 상태: TERMINATED
         */
  }
}
