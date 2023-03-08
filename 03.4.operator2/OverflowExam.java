public class OverflowExam {
    public static void main(String[] args) {
        int x = 1000000;
        int y = 1000000;
        int z = x * y;
        System.out.println(z); // -727379968(오버플로우됨)

        long x2 = 1000000;
        long y2 = 1000000;
        long z2 = x2 * y2;
        System.out.println(z2); // 1000000000000

        try {
            int result = safeAdd(200000000, 2000000000);
            System.out.println(result); // 오버플로우가 발생하여 정확하게 계산할 수 없음
        } catch(ArithmeticException e) {
            System.out.println("오버플로우가 발생하여 정확하게 계산할 수 없음");
        }
    }

    public static int safeAdd(int left, int right) {
        if (right>0) {
            if (left>(Integer.MAX_VALUE-right)) {
                throw new ArithmeticException("오버플로우 발생");
            }
        } else {
            if (left<(Integer.MIN_VALUE-right)) {
                throw new ArithmeticException("오버플로우 발생");
            }
        }
        return left + right;
    }
}