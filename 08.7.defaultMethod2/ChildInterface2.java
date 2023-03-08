public interface ChildInterface2 extends ParentInterface {
    public void method4();

    @Override
    public default void method2() {
        System.out.println("child-method2()");
    }
}
