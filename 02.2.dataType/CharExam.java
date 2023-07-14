public class CharExam {
  public static void main(String[] args) {
    char c1 = 'A';
    char c2 = 65;
    char c3 = '\u0041';

    System.out.println(c1); // A
    System.out.println(c2); // A: 유니코드 65번은 A이기 때문에
    System.out.println(c3); // A: 16진수 유니코드

    char c4 = '가';
    char c5 = 44032;
    char c6 = '\uAC00';

    System.out.println(c4); // 가
    System.out.println(c5); // 가
    System.out.println(c6); // 가

    // char 타입이 유니코드로 몇 번인지 확인
    int var1 = c1; // c1에 저장된 유니코드가 int로 저장되므로 숫자 출력
    System.out.println(var1); // 65

    int var2 = c4;
    System.out.println(var2); // 44032

  }
}
