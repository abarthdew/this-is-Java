public class TryCatch {
  public static void main(String[] args) {

    // 1. try-catch-finally
    try {
      Class clazz = Class.forName("java.lang.String2"); // 매개변수 문자로 넘어온 클래스를 찾아 변수에 리턴
      // 이 클래스가 없으면 ClassNotFountException 예외가 뜸
    } catch (ClassNotFoundException e) {
      System.out.println("클래스 존재하지 않음");
    } finally {
      System.out.println("프로그램 종료");
    }
        /*
        클래스 존재하지 않음
        프로그램 종료
         */

    // 2. RuntimeException
    try {
      String data1 = null;
      data1 = args[0];
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("실행 매개값의 수가 부족함");
      return;
    }
    // 실행 매개값의 수가 부족함
  }
}
