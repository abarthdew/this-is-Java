public class CastingCheck {
  public static void main(String[] args) {
    int i = 128;
    // byte b = (byte)i; // byte 범위는 -128 ~ 127이므로 여긴 쓰레기값이 대입됨

    if (i < -128 || i > 127) {
      System.out.println("byte타입으로 변환할 수 없음");
    } else {
      byte b = (byte) i;
      System.out.println(b);
    }
    // byte타입으로 변환할 수 없음

    int j = 125;
    if (j < Byte.MIN_VALUE || j > Byte.MAX_VALUE) {
      System.out.println("byte타입으로 변환할 수 없음");
    } else {
      byte c = (byte) j;
      System.out.println(c);
    }
    // 125

  }
}