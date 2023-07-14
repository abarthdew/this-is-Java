public class SupersonicAirplane extends Airplane {
  public static final int NORMAL = 1;
  public static final int SUPERSONIC = 2;

  @Override
  public void fly() {
    super.fly(); // 부모 메서드 호출

    // 메서드 재정의
    System.out.println("초음속 모드로 변경");
    System.out.println("초음속 모드로 비행");
  }
}
