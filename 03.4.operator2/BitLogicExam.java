public class BitLogicExam {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45&25)); // 45 & 25 = 9
        System.out.println("45 | 25 = " + (45|25)); // 45 | 25 = 61
        System.out.println("45 ^ 25 = " + (45^25)); // 45 ^ 25 = 52
        System.out.println("~45 = " + (~45)); // ~45 = -46

        System.out.println(toBinaryString(45)); // 00000000000000000000000000101101
        System.out.println(toBinaryString(25)); // 00000000000000000000000000011001
        System.out.println(toBinaryString(45&25)); // 00000000000000000000000000001001
    }

    public static String toBinaryString(int value) {
        // 이진수 만들기
        String str = Integer.toBinaryString(value);
        while(str.length() < 32) {
            str = "0" + str;
        }
        return str;
    }
}
