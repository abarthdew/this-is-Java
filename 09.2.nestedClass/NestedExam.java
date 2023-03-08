public class NestedExam {
    public static void main(String[] args) {
        NestedA a = new NestedA(); // a 객체 생성

        // 1. 인스턴스 멤버 클래스
        // NestedA.NestedB b = new NestedA.NestedB(); // 에러: NestedB는 인스턴스 멤버 클래스이기 때문에 NestedA가 생성된 후에 사용 가능
        NestedA.NestedB b = a.new NestedB();  // b 객체 생성 // NestedB의 멤버에 접근할 땐, MestedA 객체의 참조변수 a를 통해 생성자 호출
        b.field = 3;
        b.method1();

        // 2. 정적 멤버 클래스
        NestedA.NestedC c = new NestedA.NestedC(); // c 객체 생성 // 정적 멤버 클래스는 a가 없어도 바로 생성자 호출 가능
        c.field1 = 3;
        c.method1();
        NestedA.NestedC.field2 = 3;
        NestedA.NestedC.method2();

        // 3. 로컬 클래스
        a.method(); // d 객체 생성 // NestedD는 직접 호출할 수 없고, a의 method()를 호출하는 방법으로 사용
    }
}
