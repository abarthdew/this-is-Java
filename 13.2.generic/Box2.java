// 제네릭 타입
public class Box2<T> {

    private T t; // 다양한 객체를 저장할 수 있지만, 타입 변환이 빈번하게 일어나 성능에 좋지 않음

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}