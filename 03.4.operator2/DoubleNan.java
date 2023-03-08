public class DoubleNan {
    public static void main(String[] args) {
        String userInput = "NaN";

        double val = Double.valueOf(userInput);

        double currentBalance = 10000.0;
        currentBalance = currentBalance + val;
        System.out.println(currentBalance); // NaN

        // NaN이 입력되었는지 확인 후 연산하기
        double val2 = 100.0;
        double currentBalance2 = 10000.0;
        if (Double.isNaN(val2)) {
            val2 = 0.0;
        } 
        currentBalance2 = currentBalance2 + val2;
        System.out.println(currentBalance2); // 10100.0
    }
}
