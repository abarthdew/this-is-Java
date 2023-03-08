public class NestedA {

    NestedA() {
        System.out.println("a 객체 생성");

        // 생성자에서 NestedB사용 가능
        // NestedB b = new NestedB();
        // b.field = 3;
        // b.method1();
    }

    // 1. 인스턴스 멤버 클래스
    class NestedB {
        int field;
        NestedB() {
            System.out.println("b 객체 생성");
        }
        // static int field2; // static 사용 불가
        // static void method2() {};
        void method1() {}
    }

    // 2. 정적 멤버 클래스
    static class NestedC {
        int field1;
        static int field2;
        NestedC() {
            System.out.println("c 객체 생성");
        }
        void method1() {}
        static void method2() {}
    }

    // 3. 로컬 클래스
    void method() {
        class NestedD {
            int field1;
            // static int field2; // 로컬 클래스에서 static 사용 불가
            NestedD() {
                System.out.println("d 객체 생성");
            }
            void method1() {}
            // static void method2() {} // 로컬 클래스에서 static 사용 불가
        }
        NestedD d = new NestedD(); // method() 메서드를 벗어나 사용할 수 없음
        d.field1 = 3;
        d.method1();
    }
}