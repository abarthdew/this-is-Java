public class Util135 {

    // <T extends Number> 자리에 올 수 있는 구체적 타입은 Number 또는 Number의 자식 클래스
    public static <T extends Number> int compare(T t1, T t2) {
        double v1 = t1.doubleValue(); // doubleValue()은 Number의 메서드
        // 이 구현 블록에는 최상위 부모인 Number에 있는 필드, 메서드만 쓸 수 있음
        double v2 = t2.doubleValue();

        // 두 값을 비교해 t1이 크다면 1, 아니라면 -1을 리턴
        return Double.compare(v1, v2); 
    }

}
