public class Television6 implements RemoteControl6 {

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
  public void setVolume(int volume) {
    if (volume > RemoteControl6.MAX_VALUME) {
      this.volume = RemoteControl6.MAX_VALUME;
    } else if (volume > RemoteControl6.MIM_VOLUME) {
      this.volume = RemoteControl6.MIM_VOLUME;
    } else {
      this.volume = volume;
    }
    System.out.println("tv" + this.volume);
  }

}
