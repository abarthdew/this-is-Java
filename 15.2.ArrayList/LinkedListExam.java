import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExam {
    public static void main(String[] args) {
        
        // ArrayList와 LinkedList 속도 비교
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        
        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i=0; i<10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린 시간: " + (endTime - startTime) + "ns");
        // ArrayList 걸린 시간: 16941900ns

        startTime = System.nanoTime();
        for (int i=0; i<10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린 시간: " + (endTime - startTime) + "ns");
        // LinkedList 걸린 시간: 9330200ns
        
    }
}
