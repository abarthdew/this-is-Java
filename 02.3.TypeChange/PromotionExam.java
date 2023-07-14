public class PromotionExam {
  public static void main(String[] args) {
    byte byteValue1 = 10;
    byte byteValue2 = 20;
    // byte byteValue3 = byteValue1 + byteValue2; // 컴파일 에러: byteValue1, 2는 int타입으로 해석되기 때문
    int intValue = byteValue1 + byteValue2;
    System.out.println(intValue); // 30

    char charValue1 = 'A';
    char charValue2 = 1;
    // char charValue3 = charValue1 + charValue2; // 컴파일 에러: int 타입 이하의 타입 연산은 모두 int로 변환됨
    int intValue2 = charValue1 + charValue2;
    System.out.println(intValue2); // 66
    System.out.println((char) intValue2); // B

    int intValue3 = 10;
    int intValue4 = intValue3 / 4; // 정수와 정수의 연산은 결과값이 정수!
    System.out.println(intValue4); // 2

    int intValue5 = 10;
    // int intValue6 = intValue5 / 4.0; // 컴파일 에러: 실수리터럴이 포함되면, 정수(10)는 double 타입으로 변환됨
    double intValue6 = intValue5 / 4.0;
    System.out.println(intValue6); // 2.5
  }
}
