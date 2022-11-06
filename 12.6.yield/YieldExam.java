public class YieldExam {
    
    public static void main(String[] args) {
        YieldA a = new YieldA();
        YieldB b = new YieldB();

        a.start();
        b.start();
        /*
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldA의 작업 내용
        YieldA의 작업 내용
        YieldA의 작업 내용
        YieldB의 작업 내용
        ....
        (a, b 번갈아 실행)
         */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {} // main 스레드 1초간 일시정지
        a.work = false; // a에서 yield()를 호출 시켜 실행 대기 상태로 보냄
        /*
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldB의 작업 내용
        ....
        (a가 실행 대기가 되고, b만 실행)
         */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {} // main 스레드 1초간 일시정지
        a.work = true; // 스레드 a 다시 실행
        /*
        YieldB의 작업 내용
        YieldB의 작업 내용
        YieldA의 작업 내용
        YieldA의 작업 내용
        YieldA의 작업 내용
        YieldB의 작업 내용
        ....
        (a, b 번갈아 실행)
         */

        a.stop(); // 강제적 스레드 종료 - 프로그램이 불안정한 상태로 남아있을 수 있음(권장되지 않음)
        b.stop = true; // run()가 종료되도록 stop 필드 값 변경 - 동일한 스레드 종료 효과(권장)

    }

}
