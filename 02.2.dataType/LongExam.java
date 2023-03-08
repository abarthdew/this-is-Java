public class LongExam {
    public static void main(String[] args) {
        long var1 = 10;
        long var2 = 20L; // 20을 4바이트가 아닌 8바이트로 해석하라고 컴파일러에게 알려줌.
        // 물론, 20은 4바이트로 표현 가능하므로 굳이 이렇게 할 필요는 없음.

        long var3 = 100000000000L; // 4바이트 초과 정수에는 필수.

        System.out.println(var1); // 10
        System.out.println(var2); // 20
        System.out.println(var3); // 100000000000

    }
}
