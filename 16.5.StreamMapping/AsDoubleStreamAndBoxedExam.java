import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExam {
    public static void main(String[] args) {
        
        int[] intArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream
            .asDoubleStream() // int -> double
            .forEach(System.out::println); // 최종처리
            /*
            1.0
            2.0
            3.0
            4.0
            5.0
             */

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream  
            .boxed()
            .forEach(System.out::println);
            /*
            1
            2
            3
            4
            5
            */
    }
}
