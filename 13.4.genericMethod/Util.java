public class Util {

  // 리턴 타입, 매개 변수를 T로 지정함
  public static <T> Box134<T> boxing(T t) { // 이 메서드를 호출할 때 구체적인 타입이 결정됨
    Box134<T> box = new Box134<T>(); // 1. Box 객체를 만들고
    box.setT(t); // 2. 외부로부터 받은 객체를 Box 객체 안에 저장
    return box;
  }

  // <K, V> 타입 파라미터를 앞에 선언해 줌: K, V를 사용하겠다는 뜻
  public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
    boolean keyCompare = p1.getKey().equals(p2.getKey());
    boolean valueCompare = p1.getValue().equals(p2.getValue());
    return keyCompare && valueCompare;
  }

}
