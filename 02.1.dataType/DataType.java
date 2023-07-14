public class DataType {
  public static void main(String[] args) {
    int var1 = 10;
    System.out.println(var1); // 10(10진수)

    int var2 = 010;
    System.out.println(var2); // 8(8진수)

    int var3 = 0x10; // 16(16진수)
    System.out.println(var3);

    double var4 = 0.25;
    System.out.println(var4); // 0.25

    double var5 = 2E5;
    System.out.println(var5); // 200000.0

    char var6 = 'A';
    System.out.println(var6); // A

    char var7 = '한';
    System.out.println(var7); // 한

    System.out.println('\t' + "들여쓰기"); //         들여쓰기
    System.out.println("줄바꿈" + '\n' + "줄바꿈");
        /*
         줄바꿈
         줄바꿈
         */

    System.out.println("이것은 " + '\"' + "중요"); // 이것은 "중요
    System.out.println("가격이 " + '\\' + "300입니다."); // 가격이 \300입니다.

    char var8 = '\u0041';
    System.out.println(var8); // A

    System.out.println("대한 \n 민국");
        /*
         대한
         민국
         */
    System.out.println("java" + 8); // java8
    // 여기서 +는 산술연산자가 아닌, 문자열 결합 연산자로서 기능

    boolean var9 = true;
    System.out.println(var9); // true

  }
}