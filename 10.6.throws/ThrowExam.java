public class ThrowExam {

  public static void main(String[] args) {

    // findClass(); // 컴파일 오류: 예외가 이쪽으로 떠넘겨지므로 오류 발생

    try {
      findClass();
    } catch (ClassNotFoundException e) {
      System.out.println("예외 발생");
    }

  }

  public static void findClass() throws ClassNotFoundException {
    Class clazz = Class.forName("java.lang.String2"); // 존재하지 않는 클래스를 찾으므로 예외 발생
  }

}