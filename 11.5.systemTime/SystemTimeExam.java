public class SystemTimeExam {
  public static void main(String[] args) {

    long time1 = System.nanoTime();

    int sum = 0;
    for (int i = 0; i < 1000000; i++) {
      sum += i;
    }

    long time2 = System.nanoTime();
    System.out.println(sum); // 1783293664
    System.out.println(time2 - time1 + " 나노초 소요"); // 5529800 나노초 소요
  }
}
