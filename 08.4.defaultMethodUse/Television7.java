public class Television7 implements RemoteControl7 {

  int volume;

  @Override
  public void turnOn() {
    System.out.println("tv 볼륨 on");
  }

  @Override
  public void turnOff() {
    System.out.println("tv 볼륨 off");

  }

  @Override
  public void setVolume(int volume) { // 인터페이스의 default 메서드를 재정의할 때는 default를 붙이지 않음
    System.out.println("구현객체 Tv의 setVolumn"); // 재정의
  }

}
