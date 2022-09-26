public class NestedA3 {
    int field1;
    void method1() {}

    static int field2;
    static void method2() {}
    
    class NestedB3 {
        void method() { // 중첩 클래스 안 메서드 선언
            field1 = 10; // 바깥 필드(NestedA) 사용 가능
            method1();
            field2 = 10;
            method2();
        }
    }

    static class NestedC3 {
        void method() {
            // field1 = 10; // 에러: A 객체가 없어도 NestedC3은 사용 가능하기 때문
            // method1();
            field2 = 10; // A 객체가 없어도 사용 가능한 static 멤버만 사용 가능
            method2();
        }
    }
}
