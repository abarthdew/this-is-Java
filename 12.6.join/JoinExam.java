public class JoinExam {
    public static void main(String[] args) {
        
        SumThread sum = new SumThread();
        sum.start();

        System.out.println(sum.getSum()); // 0 // sum의 작업이 다 끝나지 않았는데(실행 도중) 출력될 수 있음

        // sum 스레드의 계산이 다 끝날 때까지 기다림
        try {
            sum.join();
        } catch (InterruptedException e) {}
        System.out.println(sum.getSum()); // 5050

    }
}
