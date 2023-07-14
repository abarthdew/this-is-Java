import java.util.function.IntSupplier;

public class SupplierExam {
  public static void main(String[] args) {

    IntSupplier is = () -> {
      int num = (int) (Math.random() * 6 + 1);
      return num;
    };
    int num = is.getAsInt();
    System.out.println(num); // 3

  }
}
