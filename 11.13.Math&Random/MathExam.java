public class MathExam {
  public static void main(String[] args) {

    int v1 = Math.abs(-5);
    double v2 = Math.abs(-3.14);
    System.out.println(v1); // 5
    System.out.println(v2); // 3.14

    double v3 = Math.ceil(5.3);
    double v4 = Math.ceil(-5.3);
    System.out.println(v3); // 6.0
    System.out.println(v4); // -5.0

    double v5 = Math.floor(5.3);
    double v6 = Math.floor(-5.3);
    System.out.println(v5); // 5.0
    System.out.println(v6); // -6.0

    int v7 = Math.max(5, 9);
    double v8 = Math.max(5.3, 2.5);
    System.out.println(v7); // 9
    System.out.println(v8); // 5.3

    int v9 = Math.min(5, 9);
    double v10 = Math.min(5.3, 2.5);
    System.out.println(v9); // 5
    System.out.println(v10); // 2.5

    double v11 = Math.random();
    System.out.println(v11); // 0.143242401494162

    double v12 = Math.rint(5.3);
    double v13 = Math.rint(5.7);
    System.out.println(v12); // 5.0
    System.out.println(v13); // 6.0

    long v14 = Math.round(5.3);
    long v15 = Math.round(5.7);
    System.out.println(v14); // 5
    System.out.println(v15); // 6

    double value = 12.3456;
    double temp1 = value * 100;
    long temp2 = Math.round(temp1);
    double v16 = temp2 / 100.0;
    System.out.println(v16); // 12.35

  }
}
