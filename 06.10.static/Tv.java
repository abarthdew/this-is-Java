public class Tv {
  static String company = "Samsung";
  static String model = "LCD";
  static String info;
  static int from1To10Sum;

  static {
    info = company + "/" + model;
  }

  static {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += i;
    }
    from1To10Sum = sum;
  }
}
