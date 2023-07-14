public class DmbCellPhone extends CellPhone {
  int channel;

  DmbCellPhone(String model, String color, int channel) {
    this.model = model; // 부모에게 물려받음
    this.color = color; // 부모에게 물려받음
    this.channel = channel;
  }

  void turnOnDmb() {
    System.out.println("DMB를 켭니다");
  }

  void changeChannelDmb(int change) {
    System.out.println("채널을 바꿉니다: " + channel);
  }

  void turnOffDmb() {
    System.out.println("DMB를 끕니다");
  }
}
