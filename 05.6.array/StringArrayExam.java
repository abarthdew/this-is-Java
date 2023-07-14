public class StringArrayExam {
  public static void main(String[] args) {
    String[] strArray = new String[3];
    strArray[0] = "java";
    strArray[1] = "java";
    strArray[2] = new String("java");

    System.out.println(strArray[0] == strArray[1]); // true: 서로의 번지 비교
    System.out.println(strArray[0] == strArray[2]); // false: 서로의 번지 비교
    System.out.println(strArray[0].equals(strArray[2])); // true: 리터럴과 문자열 객체 내 값 비교
  }
}
