public class BoxExam {
    public static void main(String[] args) {
        
        // Object 타입
        Box box = new Box();
        box.set("홍길동"); // String -> Object로 자동 변환되어 저장됨
        String name = (String) box.get(); // Object -> String으로 리턴값을 강제 타입 변환

        box.set(new Apple()); // Apple 또한 Object를 상속받기 때문에, Object 타입에 대입 가능

        // 제네릭 타입
        Box2 box2 = new Box2(); // 이렇게 생성해도 가능. T자리에는 Object가 들어감.
        
        Box2<String> box3 = new Box2<String>(); // String 타입만 대입 가능
        box3.set("hello"); // String 타입으로 저장됨. 불필요한 타입 변환 필요 없음.
        box3.get(); // String 타입으로 리턴됨. 불필요한 타입 변환 필요 없음.
        // box3.set(new Integer(1)); // Integer 객체이므로 컴파일 오류

    }
}

class Apple {}
