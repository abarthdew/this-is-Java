import java.util.Arrays;
import java.util.List;

public class FilterExam {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("홍길동", "김홍길동2", "김홍길동2", "홍길동", "홍길동3");
        names.stream()
            .distinct()
            .forEach(System.out::println);
            /*
            홍길동
            김홍길동2
            홍길동3
             */

        System.out.println();

        names.stream()
            .filter(n -> n.startsWith("김"))
            .forEach(System.out::println);
            /*
            김홍길동2
            김홍길동2
             */
            
        System.out.println();

        names.stream() 
            .distinct()
            .filter(s -> s.startsWith("김"))
            .forEach(System.out::println);
            /*
            김홍길동2
             */

    }
}
