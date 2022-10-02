import java.util.HashMap;

public class Key2Exam {
    public static void main(String[] args) {
        
        HashMap<Key2, String> HashMap = new HashMap();
        HashMap.put(new Key2(1), "홍길동");

        String value = HashMap.get(new Key2(1));
        // 위의 new Key2(1)와 아래의 new Key2(1)는 동등 객체인가?
        System.out.println(value); // null // 각각의 new Key2(1)는 서로 다른 hashCode를 가진 다른 객체임

        // Key2의 hashCode 재정의
        // 위의 System.out.println(value); 코드 결과가 아래와 같이 나옴을 확인할 수 있음
        /*
         hashCode 호출
        hashCode 호출
        홍길동
         */
        // "haschCode 호출"이 두 번 나온 이유는 new Key2(1)에 대한 각각의 hashCode를 조회하므로
        // 결론적으로, 두 객체가 동등한지 비교하는 로직을 재정의하려면 equals() 뿐만 아니라 hashCode도 재정의할 필요가 있음
    }
}
