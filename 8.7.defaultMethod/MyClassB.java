public class MyClassB implements MyInterface {

    @Override
    public void method1() {
        System.out.println("myClassB-method1()");
    }

    @Override
    public void method2() { // default 메서드를 재정의할 때는 default 붙이지 않음
        System.out.println("myClassB-method2()");
    }
    
}
