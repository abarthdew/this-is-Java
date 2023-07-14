import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExam2 {
  public static void main(String[] args) {

    TreeMap<Integer, String> scores = new TreeMap<>();
    scores.put(new Integer(87), "홍길동");
    scores.put(new Integer(98), "java5");
    scores.put(new Integer(75), "java1");
    scores.put(new Integer(95), "java3");
    scores.put(new Integer(86), "java2");
    scores.put(new Integer(80), "java9");

    // desendingKeySet(): 키 값으로만 내림차순 정렬
    // desendingMap(): desendingKeySet()과 비슷 + 키-값이 저장된 Map.Entry를 가져와 Map 형태의 컬렉션으로 만듬
    NavigableMap<Integer, String> dmap = scores.descendingMap();
    Set<Map.Entry<Integer, String>> desendingEntrySet = dmap.entrySet();
    for (Map.Entry<Integer, String> entry : desendingEntrySet) {
      System.out.print(entry.getKey() + "-" + entry.getValue() + " / ");
    }
    System.out.println();
    // 98-java5 / 95-java3 / 87-홍길동 / 86-java2 / 80-java9 / 75-java1 /

    // 내림차순 정렬된 dmap를 다시 내림차순하면 오름차순 됨
    NavigableMap<Integer, String> amap = dmap.descendingMap();
    Set<Map.Entry<Integer, String>> asendingEntrySet = amap.entrySet();
    for (Map.Entry<Integer, String> entry : asendingEntrySet) {
      System.out.print(entry.getKey() + "-" + entry.getValue() + " / ");
    }
    System.out.println();
    // 75-java1 / 80-java9 / 86-java2 / 87-홍길동 / 95-java3 / 98-java5 /
  }
}
