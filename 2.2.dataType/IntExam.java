public class IntExam {
    public static void main(String[] args) {
        int var1 = 10;
        int var2 = 012; // 8진수: 1*8^1 + 2*8^0 = 8 + 2 = 10
        int var3 = 0xA; // 16진수: A는 10을 뜻함.
        // int var4 = 1000000000000; // 컴파일 에러: int에 담을 수 있는 값의 범위를 초과

        System.out.println(var1); // 10
        System.out.println(var2); // 10
        System.out.println(var3); // 10
    }
}