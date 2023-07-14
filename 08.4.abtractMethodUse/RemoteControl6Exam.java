public class RemoteControl6Exam {
  public static void main(String[] args) {

    RemoteControl6 rc = null;

    // 인터페이스의 있는 추상메서드를 호출한다는 것은 구현 객체의 재정의된 실제 메서드를 호출한다는 것과 같음
    rc = new Television6();
    rc.turnOn(); // tv 볼륨 on
    rc.turnOff(); // tv 볼륨 off

    rc = new Audio6();
    rc.turnOn(); // audio 볼륨 on
    rc.turnOff(); // audio 볼륨 off
  }
}
