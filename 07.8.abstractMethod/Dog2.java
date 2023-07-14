public class Dog2 extends Animal2 {
  public Dog2() {
    this.kind = "포유류";
  }

  public void sound() { // 상속받은 부모 메서드를 자식 메서드에서 재정의해야 함(필수)
    System.out.println("멍멍");
  }

  ;
}