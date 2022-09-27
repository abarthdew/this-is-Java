public class Anonymous {
    // 1. 필드의 초기값으로서의 익명 자식 객체
    Person9 field = new Person9() {
        String studentNo; // 새로운 필드
        void work() { // 새로운 메서드
            System.out.println("출근합니다");
        }
        @Override
        void wake() { // 재정의된 메서드
            System.out.println("6시에 일어납니다");
            work(); // 익명 객체 내 멤버는 재정의된 메서드 내에서 사용 가능, 블록 외부에선 사용 불가능
        }
    };

    // 2. 로컬 변수의 초기값으로서의 익명 자식 객체
    void method1() {
        Person9 localVar = new Person9() { // 로컬 변수에도 익명 자식 객체 대입 가능
            String studentNo; // 새로운 필드
            void walk() { // 새로운 메서드
                System.out.println("산책합니다");
            }
            @Override
            void wake() { // 재정의된 메서드
                System.out.println("9시에 일어납니다");
                walk(); 
            }
        };
        localVar.wake();
    };

    // 3. 매개 변수의 값으로서의 익명 자식 객체
    void method2(Person9 person) { // 매개값으로 익명 자식 객체 대입
        person.wake();
    }
}
