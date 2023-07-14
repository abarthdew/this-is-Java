public class BitReverseExam {
  public static void main(String[] args) {
    int v1 = 10;
    int v2 = ~v1;
    int v3 = ~v1 + 1;
    System.out.println(v2); // -11
    System.out.println(v3); // -10

    int v4 = -10;
    int v5 = ~~v4;
    int v6 = ~v4 + 1;
    System.out.println(v5); // -10
    System.out.println(v6); // 10

    System.out.println(toBinaryString(v1) + " / 십진수 : " + v1); // 00000000000000000000000000001010 / 십진수 : 10
    System.out.println(toBinaryString(v2) + " / 십진수 : " + v2); // 11111111111111111111111111110101 / 십진수 : -11
  }

  public static String toBinaryString(int value) { // value를 2진 문자열로 변환
    String str = Integer.toBinaryString(value);
    while (str.length() < 32) {
      str = "0" + str;
    }
    return str;
  }
}
