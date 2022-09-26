public class ChildExam {
    public static void main(String[] args) {
        
        // 1. 부모의 default 메서드를 그대로 가짐
        ChildInterface ci1 = new ChildInterface() { // 익명 클래스로 재정의
            @Override
            public void method1() {
                System.out.println("child-method1()");
            }
            @Override
            public void method3() {
                System.out.println("child-method3()");
            }
        };
        ci1.method1(); // child-method1() // 익명 클래스에서 재정의
        ci1.method2(); // parent-method2() // 부모의 default 메서드를 그대로 사용
        ci1.method3(); // child-method3() // 익명 클래스에서 재정의
        
        // 2. 자식 인터페이스에서 부모의 default 메서드 재정의
        ChildInterface2 ci2 = new ChildInterface2() {
            @Override
            public void method1() {
                System.out.println("child-method1()");
            }
            @Override
            public void method4() {
                System.out.println("child-method4()");
            }
        };
        ci2.method1(); // child-method1() // 익명 클래스에서 재정의
        ci2.method2(); // child-method2() // 자식 인터페이스에서 부모 default 메서드 재정의
        ci2.method4(); // child-method4() // 익명 클래스에서 재정의

        // 3. 부모의 default 메서드를 자식 인터페이스에서 추상 메서드로 만듬

        ChildInterface3 ci3 = new ChildInterface3() {
            @Override
            public void method1() {
                System.out.println("child-method1()");
            }
            @Override
            public void method5() {
                System.out.println("child-method5()");
            }
            @Override
            public void method2() {
                System.out.println("child-method2()");
            }
        };
        ci3.method1(); // child-method1() // 익명 클래스에서 재정의
        ci3.method2(); // child-method2() // 자식 인터페이스에서 부모 default 메서드 추상화 -> 구현 클래스에서 재정의
        ci3.method5(); // child-method5() // 익명 클래스에서 재정의

    }

}
