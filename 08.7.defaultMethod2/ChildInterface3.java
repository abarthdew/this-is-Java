public interface ChildInterface3 extends ParentInterface {
    public void method5();

    @Override
    public void method2(); // default 키워드 지우고, 실행블록 삭제: 구현 클래스에서 재정의 필수
}
