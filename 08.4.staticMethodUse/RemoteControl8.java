public interface RemoteControl8 {
  int MAX_VALUME = 10;
  int MIM_VOLUME = 0;

  void turnOn();

  void turnOff();

  // static 메서드 선언
  static void changeBattery() {
    System.out.println("인터페이스의 changeBattery");
  }
}
