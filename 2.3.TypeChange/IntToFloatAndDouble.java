public class IntToFloatAndDouble {
    public static void main(String[] args) {
        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = num2;
        num2 = (int) num3;

        int result = num1 - num2;
        System.out.println(result); // -4

        int num11 = 123456780;
        int num12 = 123456780;

        double num13 = num12;
        num12 = (int) num13;

        int result2 = num11 - num12;
        System.out.println(result2); // 0
    }
}
