public class SignOperator {
    public static void main(String[] args) {
        int x = -100;
        int result1 = +x;
        int result2 = -x;
        System.out.println(result1); // -100
        System.out.println(result2); // 100

        short s = 100;
        // short result3 = -s; // 컴파일 에러: 정수에 부호 연산자가 붙으면 int 타입으로 해석되기 때문에
        int result3 = -s;
        System.out.println(result3); // -100
    }
}
