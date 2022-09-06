public class BitShiftExam {
    public static void main(String[] args) {
        System.out.println(1 >> 3); // 0
        System.out.println(-8 >> 3); // -1
        System.out.println(-8 >>> 3); // 536870911
        
        System.out.println(toBinaryString(-8)); // 11111111111111111111111111111000
        System.out.println(toBinaryString(-8 >> 3)); // 11111111111111111111111111111111
        System.out.println(toBinaryString(-8)); // 11111111111111111111111111111000
        System.out.println(toBinaryString(-8 >>> 3)); // 00011111111111111111111111111111
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
