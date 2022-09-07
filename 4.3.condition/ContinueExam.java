public class ContinueExam {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            if(i%2 != 0) { // 홀수일 때 제외
                continue;
            }
            System.out.println(i);
            /*
            0
            2
            4
            6
            8
             */
        }
    }
}
