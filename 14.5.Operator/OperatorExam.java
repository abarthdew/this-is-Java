import java.util.function.IntBinaryOperator;

public class OperatorExam {
    private static int[] scores = {92, 95, 87};

    // IntBinaryOperator: 두 개의 정수값을 받아 하나를 리턴
    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score); // result, score 둘을 비교해 이 중 큰 값, 혹은 작은 값을 리턴
        }
        return result;
    }
    public static void main(String[] args) {
        
        // 최대값 얻기
        int max = maxOrMin((a, b) -> {
            if (a >= b) {
                return a;
            } else {
                return b;
            }
        });
        System.out.println("최대값: " + max); // 최대값: 95

        // 최소값 얻기
        int min = maxOrMin((a, b) -> {
            if (a <= b) {
                return a;
            } else {
                return b;
            }
        });
        System.out.println("최소값: " + min); // 최소값: 87

    }
}
