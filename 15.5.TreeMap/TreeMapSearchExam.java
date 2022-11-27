import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapSearchExam {
    public static void main(String[] args) {
        
        TreeMap<String, Integer> scores = new TreeMap<>();
        scores.put("apple", new Integer(87));
        scores.put("forever", new Integer(98));
        scores.put("description", new Integer(75));
        scores.put("ever", new Integer(95));
        scores.put("zoo", new Integer(86));
        scores.put("base", new Integer(80));
        scores.put("guess", new Integer(80));
        scores.put("cherry", new Integer(80));

        System.out.println("c~f 사이의 단어 검색");
        NavigableMap<String, Integer> map = scores.subMap("c", true, "f", true);
        // subMap(a, b, c, d);
        // a: 시작 단어
        // b: a 포함 여부
        // c: 끝 단어
        // d: c포함 여부

        // map.entrySet() 을 사용해 Map.Entry 객체를 Set 컬렉션에 담아 리턴
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue());
            /*
            c~f 사이의 단어 검색
            cherry / 80
            description / 75
            ever / 95
             */
        }

    }
}
