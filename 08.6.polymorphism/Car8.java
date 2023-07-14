public class Car8 {
  Tire8 frontLeftTire = new HankookTire8();
  Tire8 frontRightTire = new HankookTire8();
  Tire8 backLeftTire = new HankookTire8();
  Tire8 backRightTire = new HankookTire8();

  void run() {
    frontLeftTire.roll();
    frontRightTire.roll();
    backLeftTire.roll();
    backRightTire.roll();
  }
}
