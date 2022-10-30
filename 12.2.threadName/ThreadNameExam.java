public class ThreadNameExam {
    public static void main(String[] args) {
        
        // main() 메서드를 실행하는 스레드가 어떤 스레드인지 확인하기
        Thread thread = Thread.currentThread(); // 현재 main() 메서드를 실행하는 스레드의 인스턴스 얻기
        System.out.println(thread.getName()); // main

        // 새로운 작업 스레드를 만들고 스레드 이름 등록 후, 그 이름을 얻어내기
        Thread thread2  = new ThreadA();
        System.out.println("ThreadA를 생성한 스레드: " + Thread.currentThread().getName()); // ThreadA를 생성한 스레드: main
        // 해당 스레드를 생성한 스레드(ThreadA를 생성한 스레드)
        // 즉, 현재 이 코드를 실행하는 스레드를 얻어, 이름을 가져온다
        thread2.start(); // Thread-0
        // ** 정리: 아래 두 코드는 main 에서 실행되지만, **
        // Thread thread2  = new ThreadA();
        // thread2.start();
        // ** thread.start()를 하는 순간, ThreadA의 run() 메서드가 실행됨

        Thread thread3  = new ThreadB();
        System.out.println("ThreadB를 생성한 스레드: " + Thread.currentThread().getName()); // ThreadB를 생성한 스레드: main
        // (ThreadB를 생성한 스레드)
        thread3.start(); // NAME_ThreadB

        Thread thread4  = new ThreadC();
        thread4.start(); // Thread-2

        System.out.println("작업 스레드 이름(ThreadA의 이름): " + thread2.getName()); // 작업 스레드 이름(ThreadA의 이름): Thread-0 // main 스레드에서 threadA의 이름을 얻기위해 호출
        System.out.println("작업 스레드 이름(ThreadB의 이름): " + thread3.getName()); // 작업 스레드 이름(ThreadB의 이름): NAME_ThreadB

        /*
        (전체 출력 내용)
        main
        ThreadA를 생성한 스레드: main
        ThreadB를 생성한 스레드: main
        Thread-0
        Thread-0
        NAME_ThreadB
        Thread-2
        Thread-2
        작업 스레드 이름(ThreadA의 이름): Thread-0
        NAME_ThreadB
        작업 스레드 이름(ThreadB의 이름): NAME_ThreadB
         */
    }
}
