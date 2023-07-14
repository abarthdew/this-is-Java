public class ChildExam2 {
  public static void main(String[] args) {
    Parent2 parent = new Child2();
    parent.field1 = "data";
    parent.method1(); // parent-method1()
    parent.method2(); // parent-method2()

    // parent.field2 = "data"; // 컴파일 에러: 부모 타입이므로 자식 객체 멤버 사용 불가
    // parent.method3(); // 컴파일 에러: 부모 타입이므로 자식 객체 멤버 사용 불가

    Child2 child = (Child2) parent; // 강제 타입 변환
    child.field2 = "data2"; // 자식 객체 멤버 사용 가능
    child.method3(); // child-method3() // 자식 객체 멤버 사용 가능
  }

}
