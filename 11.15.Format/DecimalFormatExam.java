import java.text.DecimalFormat;

public class DecimalFormatExam {
  public static void main(String[] args) {

    double num = 1234567.89;
    DecimalFormat df = new DecimalFormat("0");
    System.out.println(df.format(num)); // 1234568

    df = new DecimalFormat("000000000.0000");
    System.out.println(df.format(num)); // 001234567.8900

    df = new DecimalFormat("#########.####");
    System.out.println(df.format(num)); // 1234567.89

    df = new DecimalFormat("#,###.0");
    System.out.println(df.format(num)); // 1,234,567.9

  }
}
