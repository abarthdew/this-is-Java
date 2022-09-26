public class NestedA2 {
    
    class NestedB2 {}

    static class NestedC2 {}

    // 인스턴스 필드
    NestedB2 field1 = new NestedB2();
    NestedC2 field2 = new NestedC2();

    // 인스턴스 메서드
    void method1() {
        NestedB2 var1 = new NestedB2();
        NestedC2 var2 = new NestedC2();
    }

    // 정적 필드
    // static NestedB2 field3 = new NestedB2(); // 에러: A 객체가 생성되지 않았기 때문에 사용 불가
    static NestedC2 field4 = new NestedC2(); // NestedC2 클래스는 static이므로 A 객체 생성 없이 사용 가능

    // 정적 메서드
    static void method2() {
        // NestedB2 var1 = new NestedB2(); // 에러: method2()가 static이라 A 객체 없이도 사용 가능한데, B는 불가능
        NestedC2 var2 = new NestedC2(); // NestedC2 클래스는 static이므로 A 객체 생성 없이 사용 가능
    }
}
