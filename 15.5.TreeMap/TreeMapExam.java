import java.util.Map;
import java.util.TreeMap;

public class TreeMapExam {
    public static void main(String[] args) {
        
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(new Integer(87), "홍길동");
        scores.put(new Integer(98), "java5");
        scores.put(new Integer(75), "java1");
        scores.put(new Integer(95), "java3");
        scores.put(new Integer(86), "java2");
        scores.put(new Integer(80), "java9");
        // 저장을 할 때는 무작위로 저장되지만,
        // 실제 TreeMap에 저장될 때는 이진트리로 저장되기 때문에 키값을 비교해, 가장 작은 수부터 왼쪽 노드로 옴

        // 검색을 해서 저장할 Map.Entry 객체 생성
        Map.Entry<Integer, String> entry = null;
        entry = scores.firstEntry(); // 가장 왼쪽 객체
        System.out.println("가장 낮은 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 가장 낮은 점수: 75-java1
        
        entry = scores.lastEntry();
        System.out.println("가장 높은 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 가장 높은 점수: 98-java5
        
        entry = scores.lowerEntry(95);
        System.out.println("95점 아래 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 95점 아래 점수: 87-홍길동

        entry = scores.higherEntry(95);
        System.out.println("95점 위 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 95점 위 점수: 98-java5

        entry = scores.floorEntry(95);
        System.out.println("95점이거나 바로 아래 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 95점이거나 바로 아래 점수: 95-java3

        entry = scores.ceilingEntry(95);
        System.out.println("95점이거나 바로 위 점수: " + entry.getKey() + "-" + entry.getValue() + "\n"); // 95점이거나 바로 위 점수: 95-java3

        // 모두 출력하기
        while(!scores.isEmpty()) {
            entry = scores.pollFirstEntry();
            System.out.println(entry.getKey() + " | 남은 객체 수: " + scores.size());
            /*
            75 | 남은 객체 수: 5
            80 | 남은 객체 수: 4
            86 | 남은 객체 수: 3
            87 | 남은 객체 수: 2
            95 | 남은 객체 수: 1
            98 | 남은 객체 수: 0
             */
        }
        
    }
}
