@FunctionalInterface // 컴파일러가 이 인터페이스에 몇 개의 메서드가 선언되었는지 확인, 메서드가 두 개 이상이라면 컴파일 오류를 발생시킴
// 즉, 이 인터페이스가 하나의 메서드를 가지고 있는지 체크하는 역할
public interface MyFuncInterface {

  public void method();

}