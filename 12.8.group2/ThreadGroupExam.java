public class ThreadGroupExam {
    public static void main(String[] args) {
        

        ThreadGroup myFGroup = new ThreadGroup("myGroup");
        WorkThread workThreadA = new WorkThread(myFGroup, "workThreadA");
        WorkThread workThreadB = new WorkThread(myFGroup, "workThreadB");

        workThreadA.start();
        workThreadB.start();

        System.out.println("main 스레드 그룹의 list() 메서드 출력 내용");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup(); // 현재 스레드 그룹(이 경우 main) return
        mainGroup.list(); // mainGroup의 현재 상황 출력, 즉, main 그룹 내 하위 그룹 포함 전부 출력
        /*
        main 스레드 그룹의 list() 메서드 출력 내용
        java.lang.ThreadGroup[name=main,maxpri=10]
            Thread[main,5,main]
            java.lang.ThreadGroup[name=myGroup,maxpri=10]       
                Thread[workThreadA,5,myGroup]
                Thread[workThreadB,5,myGroup]
         */

        // main 스레드 3초 동안 일시정지
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        System.out.println("myGroup 스레드 그룹의 interrupt() 메서드 호출");
        // 이 그룹에 소속된 모든 스레드가 interrupt() 메서드를 호출하며, 모두가 안전하게 종료됨
        myFGroup.interrupt();
        /*
        myGroup 스레드 그룹의 interrupt() 메서드 호출
        workThreadA interrupted
        workThreadB interrupted
        workThreadB 가 종료됨
        workThreadA 가 종료됨
         */

        // 스레드 그룹에서 한 번만 interrupt() 메서드를 호출하게 되면,
        // 그 그룹 내 포함된 모든 스레드들이 전부 interrupt 됨으로써, 안전하게 종료가 가능

    }   
}
