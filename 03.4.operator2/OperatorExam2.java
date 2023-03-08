public class OperatorExam2 {
    public static void main(String[] args) {
        int v1 = 5;
        int v2 = 2;

        int result1 = v1 + v2;
        System.out.println(result1); // 7

        int result2 = v1 - v2;
        System.out.println(result2); // 3

        int result3 = v1 * v2;
        System.out.println(result3); // 10

        int result4 = v1 / v2;
        System.out.println(result4); // 2

        int result5 = v1 % v2;
        System.out.println(result5); // 1

        double result6 = (double) v1 / v2;
        System.out.println(result6); // 2.5

        char c1 = 'A' + 1; // 리터럴 + 정수 = 가능
        System.out.println(c1); // B
        char c2 = 'A';
        // char c3 = c2 + 1; // 컴파일 에러: char타입 변수 + 정수 = 자바에서는 변수 + 정수 산술연산을 할 때, 정수를 int로 해석
        int c3 = c2 + 1;
        System.out.println(c3); // 66
        char c4 = (char)c3;
        System.out.println(c4); // B
    }
}
