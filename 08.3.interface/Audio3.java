public class Audio3 implements RemoteControl3 {

  int volume;

  // 추상메서드 재정의
  @Override
  public void turnOn() {
    System.out.println("audio 볼륨 on");
  }

  @Override
  public void turnOff() {
    System.out.println("audio 볼륨 off");

  }

  @Override
  public void setVolume(int volume) {
    if (volume > RemoteControl3.MAX_VALUME) {
      this.volume = RemoteControl3.MAX_VALUME;
    } else if (volume > RemoteControl3.MIM_VOLUME) {
      this.volume = RemoteControl3.MIM_VOLUME;
    } else {
      this.volume = volume;
    }
    System.out.println("audio " + this.volume);
  }
}
