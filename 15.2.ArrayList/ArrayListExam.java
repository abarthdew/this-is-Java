import java.util.ArrayList;
import java.util.List;

public class ArrayListExam {
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        // 초기 생성 시 저장 가능 객체(capacity): 10개

        list.add("java"); // 비어있는 마지막 인덱스에 String 객체 저장
        list.add("jdbc");
        list.add("servlet/jsp");
        list.add(2, "Database");
        list.add("ibatis");

        int size = list.size();
        System.out.println("총 객체수: " + size); // 총 객체수: 5

        for (String li : list) {
            System.out.println(li);
            /*
            java
            jdbc
            Database
            servlet/jsp
            ibatis
             */
        }

        System.out.println();
        list.remove(2);
        for (String li : list) {
            System.out.println(li);
            /*
            java
            jdbc
            servlet/jsp
            ibatis
             */
        }
        
        System.out.println();
        list.remove("ibatis");
        for (String li : list) {
            System.out.println(li);
            /*
            java
            jdbc
            servlet/jsp
             */
        }

    }
}