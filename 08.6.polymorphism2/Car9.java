public class Car9 {
  Tire9[] tires = {
    new HankookTire9(),
    new HankookTire9(),
    new HankookTire9(),
    new HankookTire9()
  };

  void run() {
    for (Tire9 tire : tires) {
      tire.roll();
    }
  }
}
