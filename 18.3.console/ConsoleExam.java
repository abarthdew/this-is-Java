import java.io.Console;

public class ConsoleExam {
  public static void main(String[] args) {

    Console console = System.console();
    System.out.println("아이디: ");
    String id = console.readLine();

    System.out.println("패스워드: ");
    char[] charPass = console.readPassword();
    String strPassword = new String(charPass); // 문자열 변환

    System.out.println(id);
    System.out.println(strPassword);
        /*
        아이디: 
        id
        패스워드: 

        id
        pass
         */

  }
}
