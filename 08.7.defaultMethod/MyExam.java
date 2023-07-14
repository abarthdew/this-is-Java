public class MyExam {
  public static void main(String[] args) {

    MyInterface m1 = new MyClassA();
    m1.method1(); // myClassA-method1()

    MyInterface m2 = new MyClassB();
    m2.method1(); // myClassB-method1()
    m2.method2(); // myClassB-method2()

  }
}
