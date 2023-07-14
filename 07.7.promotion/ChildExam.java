public class ChildExam {
  public static void main(String[] args) {
    Child child = new Child();
    Parent parent = child;

    parent.method1(); // parent-method1()
    parent.method2(); // child-method2()
    // parent.method3(); // 컴파일 에러: parent에 method3()이 없음
  }
}