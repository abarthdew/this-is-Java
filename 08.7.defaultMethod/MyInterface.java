public interface MyInterface {

    public void method1();

    public default void method2() {} // 추상 메서드가 아니기 때문에, 구현 클래스에서 재정의해도 되고, 안 해도 됨

}