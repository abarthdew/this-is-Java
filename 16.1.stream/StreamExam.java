import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam {
    public static void main(String[] args) {
        
        List<String> list = Arrays.asList("홍길동", "1", "2");

        // Iterator 이용
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String name = iter.next(); // next(): list의 요소를 하나씩 가져옴
            System.out.println(name);
            /*
            홍길동
            1
            2
             */
        }

        // Stream
        Stream str = list.stream();
        str.forEach(name -> System.out.println(name));
        /*
        홍길동
        1
        2
         */

    }
}