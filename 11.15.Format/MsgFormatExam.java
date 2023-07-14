import java.text.MessageFormat;

public class MsgFormatExam {
  public static void main(String[] args) {

    String id = "java";
    String name = "홍길동";
    String tel = "010-123-4567";

    String text = "회원 id: {0}, \n회원 이름: {1}, \n회원 전화: {2}";
    String result1 = MessageFormat.format(text, id, name, tel);
    System.out.println(result1);
        /*
        회원 id: java, 
        회원 이름: 홍길동,     
        회원 전화: 010-123-4567
         */

    String sql = "insert into member values({0}, {1}, {2})";
    Object[] arguments = {"java", "홍길동", "010-123-4567"};
    String result2 = MessageFormat.format(sql, arguments);
    System.out.println(result2); // insert into member values(java, 홍길동, 010-123-4567)

  }
}
