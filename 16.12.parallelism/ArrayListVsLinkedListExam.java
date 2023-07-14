import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ArrayList와 LinkedList 병렬 처리 비교
public class ArrayListVsLinkedListExam {

  // 요소 처리
  public static void work(int value) {
    // 그냥 실행용
  }

  // 병렬 처리
  public static long testParallel(List<Integer> list) {
    long start = System.nanoTime();
    list.stream().parallel() // 매개 값으로 받은 컬렉션의 순차 스트림을 얻고 병렬 처리 스트림으로 변경
      .forEach((a) -> work(a)); // 요소를 하나씩 가져와 work()에 매개값으로 제공
    long end = System.nanoTime();
    long runTime = end - start;
    return runTime;
  }

  public static void main(String[] args) {

    // 소스 컬렉션
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < 100000; i++) { // 100만 개의 요소를 각 컬렉션에 저장
      arrayList.add(i);
      linkedList.add(i);
    }

    // 워밍업: 병렬 처리 한번 실행해 봄
    long arrayListParallel = testParallel(arrayList);
    long linkedListParallel = testParallel(linkedList);

    // 병렬 스트림 처리 시간 구하기
    arrayListParallel = testParallel(arrayList);
    linkedListParallel = testParallel(linkedList);

    if (arrayListParallel < linkedListParallel) {
      System.out.println("성능 테스트 결과: ArrayList 처리가 더 빠름");
    } else {
      System.out.println("성능 테스트 결과: LinkedList 처리가 더 빠름");
    }
    // (출력) 성능 테스트 결과: ArrayList 처리가 더 빠름

  }
}
