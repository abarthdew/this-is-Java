public class RemoteControlExam5 {
  public static void main(String[] args) {

    SmartTv tv = new SmartTv();

    RemoteControl5 rc = tv; // 한 번은 RemoteControl로 사용하고,
    Searchable sc = tv; // 한 번은 Searchable로 사용할 수 있음

    // 이렇게 인터페이스 변수에 대입하게 되면, 각각 인터페이스에 선언된 추상 메서드만 변수로 호출 가능
    rc.turnOn();
    rc.turnOff();
    rc.setVolume(5);

    sc.search("http://aaa.com");

  }
}
