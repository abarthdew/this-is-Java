import java.util.Arrays;
import java.util.List;

public class ArraysAsListExam {
  public static void main(String[] args) {

    List<String> list
      = Arrays.asList("홍길동", "신용권", "김자바"); // 내부적으로 ArrayList가 생성, add()로 각각 객체를 저장한 효과와 동일함
    for (String name : list) {
      System.out.println(name);
            /*
            홍길동
            신용권
            김자바
             */
    }

    List<Integer> list2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
    for (Integer val : list2) {
      System.out.println(val);
            /*
            1     
            2     
            3  
             */
    }

  }
}
