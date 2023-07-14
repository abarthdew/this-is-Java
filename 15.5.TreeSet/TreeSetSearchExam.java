import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetSearchExam {
  public static void main(String[] args) {

    TreeSet<String> s = new TreeSet<>();
    s.add("apple");
    s.add("forever");
    s.add("description");
    s.add("ever");
    s.add("zoo");
    s.add("base");
    s.add("guess");
    s.add("cherry");
    // 알파벳 순서에 따라 배치됨

    // c - f 사이의 단어를 검색
    NavigableSet<String> nset = s.subSet("c", true, "f", true);
    // subSet(a, b, c, d);
    // a: 시작 단어
    // b: a 포함 여부
    // c: 끝 단어
    // d: c포함 여부
    for (String word : nset) {
      System.out.println("c~f 사이의 단어 검색: " + word);
            /*
            c~f 사이의 단어 검색: cherry
            c~f 사이의 단어 검색: description
            c~f 사이의 단어 검색: ever
             */
    }

  }
}
