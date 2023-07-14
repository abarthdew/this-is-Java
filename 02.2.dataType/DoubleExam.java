public class DoubleExam {
  public static void main(String[] args) {
    // 실수값 저장
    double var1 = 3.14;
    float var2 = 3.14F;

    // 정밀도 검사
    double var3 = 0.123456789123456789;
    float var4 = 0.12345678923456789F;

    System.out.println(var1); // 3.14
    System.out.println(var2); // 3.14
    System.out.println(var3); // 0.12345678912345678
    System.out.println(var4); // 0.12345679 (메모리 용량 상 표현할 수 있는 자릿수가 제한됨)

    // e 사용하기
    int var6 = 300000;
    double var7 = 3e6;
    float var8 = 3e6F;
    System.out.println(var6); // 300000
    System.out.println(var7); // 3000000.0 (실제 저장될 때는 지수로 변환되기 때문에 .0이 붙음)
    System.out.println(var8); // 3000000.0
  }
}
