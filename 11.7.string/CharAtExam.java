public class CharAtExam {
  public static void main(String[] args) {

    String ssn = "012345-1231231";
    char sex = ssn.charAt(7);
    System.out.println(sex); // 1

    switch (sex) {
      case '1':
        System.out.println("남자");
        break;
      case '3':
      case '2':
      case '4':
        System.out.println("여자");
        break;
    } // 남자
  }
}
