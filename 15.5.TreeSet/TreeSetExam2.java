import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExam2 {
    public static void main(String[] args) {
        
        TreeSet<Integer> scores = new TreeSet<>();
        scores.add(new Integer(87));
        scores.add(new Integer(98));
        scores.add(new Integer(75));
        scores.add(new Integer(95));
        scores.add(new Integer(80));
        // 저장할 때는 무작위,
        // 실제 저장될 때는 이진트리로 저장됨

        // scores.descendingIterator(); // 내림차순으로 정렬한 반복자를 얻는 것
        NavigableSet<Integer> dset = scores.descendingSet(); // 내림차순으로 정렬된 Set 컬렉션을 얻음
        for (Integer score : dset) {
            System.out.print(score + " ");
        }
        System.out.println();
        // 98 95 87 80 75 

        NavigableSet<Integer> aset = dset.descendingSet();
        // desendingSet() 한 것을 다시 desendingSet()하면 내림차순 -> 오름차순으로 바뀜
        for (Integer score : aset) {
            System.out.print(score + " ");
        }
        System.out.println();
        // 75 80 87 95 98
    }
}
