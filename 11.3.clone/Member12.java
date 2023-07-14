import java.util.Arrays;

public class Member12 implements Cloneable {
  public String name;
  public int age;
  public int[] score;
  public Car12 car;

  public Member12(String name, int age, int[] score, Car12 car) {
    this.name = name;
    this.age = age;
    this.score = score;
    this.car = car;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Member12 cloned = (Member12) super.clone(); // Object에 있는 clone()을 호출해야 함(super를 빼먹을 시 스택 오버플로우 에러발생)
    // Object에 있는 clone()을 호출해 먼저 얕은 복사를 한 후 이 밑에 줄부터 재정의하는 것!

    cloned.score = Arrays.copyOf(this.score, this.score.length); // clone.score에 똑같은 배열을 새롭게 만들어 대입
    cloned.car = new Car12(this.car.model); // Car12 객체도 참조 타입이므로 똑같은 객체를 새로 만들어 대입
    return cloned;
  }

  public Member12 getMember() {
    Member12 cloned = null;
    try {
      cloned = (Member12) clone(); // 재정의된 clone()을 호출
    } catch (CloneNotSupportedException e) {
    }
    return cloned;
  }
}