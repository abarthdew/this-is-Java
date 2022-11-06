import java.util.Map;
import java.util.Set;

public class ThreadInfoExam {
    public static void main(String[] args) {
        
        AutoSaveThread2 auto = new AutoSaveThread2();
        auto.setName("AutoSaveThread");
        auto.setDaemon(true);
        auto.start();

        Map<Thread, StackTraceElement[]> map // 리턴 타입
            = Thread.getAllStackTraces(); // stack에 있는 모든 스레드를 추적해서 가져온다
        Set<Thread> threads = map.keySet();
        for (Thread thread : threads) {
            System.out.println("name: " + thread.getName() + ((thread.isDaemon() ? "(데몬)" : "(주)")));
            System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
            System.out.println();
            /*
            name: Signal Dispatcher(데몬)
            소속그룹: system

            name: AutoSaveThread(데몬)
                    소속그룹: main(main 스레드에서 이 스레드를 생성했기 때문에)

            name: main(주)
                    소속그룹: main

            name: Attach Listener(데몬)
                    소속그룹: system

            name: Finalizer(데몬)
                    소속그룹: system

            name: Reference Handler(데몬)
                    소속그룹: system
             */
        }

    }
}
