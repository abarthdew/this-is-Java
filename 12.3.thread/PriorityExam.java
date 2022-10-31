public class PriorityExam {
    public static void main(String[] args) {
        
        for (int i=0; i<=10; i++) {
            Thread thread = new CalcThread("Thread" + i);
            if (i != 10) {
                thread.setPriority(Thread.MIN_PRIORITY);
            } else {
                thread.setPriority(Thread.MAX_PRIORITY); // Thread10에 가장 큰 우선순위를 주었으므로
            }
            thread.start();
            // 무조건 Thread10이 제일 빨리 끝남
            /*
            Thread10
            Thread4
            Thread9
            Thread8
            Thread2
            Thread0
            Thread7
            Thread1
            Thread6
            Thread5
            Thread3
             */
        }

    }
}
