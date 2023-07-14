import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExam {
  public static void main(String[] args) {

    TreeSet<Integer> scores = new TreeSet<>();
    scores.add(new Integer(87));
    scores.add(new Integer(98));
    scores.add(new Integer(75));
    scores.add(new Integer(95));
    scores.add(new Integer(80));
    // 저장이 될 때는 무작위로 저장
    // 저장이 되고 나서는 이진트리를 이루므로 가장 작은 것부터 순서를 이룸

    Integer score = null;
    score = scores.first(); // TreeSet에서 가장 왼쪽에 있는 숫자(가장 작은 숫자)
    System.out.println("가장 낮은 점수: " + score); // 75

    score = scores.last();
    System.out.println("가장 높은 점수: " + score); // 98

    score = scores.lower(95); // 주어진 객체의 왼쪽 자식 노드(바로 아래 있는 객체)를 리턴함
    // 95의 바로 아래 값이 출력됨
    System.out.println("95 아래 점수: " + score); // 87

    score = scores.higher(new Integer(95));
    System.out.println("95 위 점수: " + score); // 98

    score = scores.floor(new Integer(95)); // 95 또는 95보다 작은 객체 리턴
    System.out.println("95거나 바로 아래 점수: " + score); // 95

    score = scores.ceiling(85);
    System.out.println("85거나 바로 위 점수: " + score); // 87

    // 방법 1) treeset에 있는 점수들을 모두 출력
    while (!scores.isEmpty()) {
      score = scores.pollFirst(); // 가장 왼쪽 자식 노드부터 하나씩 빼냄 - TreeSet에서 객체가 빠짐(제거됨)
      // pollFirst(): 가장 왼쪽 객체부터 가져온 뒤 제거
      System.out.println(score + " | 남은 객체 수: " + scores.size());
            /*
            75 | 남은 객체 수: 4
            80 | 남은 객체 수: 3
            87 | 남은 객체 수: 2
            95 | 남은 객체 수: 1
            98 | 남은 객체 수: 0
             */
    }

    // 방법 2) treeset에 있는 점수들을 모두 출력
    while (!scores.isEmpty()) {
      score = scores.pollLast();
      // pollLast(): 가장 오른쪽 객체부터 가져온 뒤 제거
      System.out.println(score + " | 남은 객체 수: " + scores.size());
            /*
            98 | 남은 객체 수: 4
            95 | 남은 객체 수: 3
            87 | 남은 객체 수: 2
            80 | 남은 객체 수: 1
            75 | 남은 객체 수: 0
             */
    }

    // 방법3)
    Iterator<Integer> iterator = scores.iterator();
    while (iterator.hasNext()) {
      int s = iterator.next(); // iterator는 가져오기만 할 뿐 객체를 제거하지 않음
      iterator.remove(); // remove()를 사용해야 제거됨
      System.out.println(s + " | 남은 객체 수: " + scores.size());
            /*
            75 | 남은 객체 수: 4
            80 | 남은 객체 수: 3
            87 | 남은 객체 수: 2
            95 | 남은 객체 수: 1
            98 | 남은 객체 수: 0
             */
    }

  }
}