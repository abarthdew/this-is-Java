public class NestedBreak {
  public static void main(String[] args) {

    Outer:
    for (char upper = 'A'; upper <= 'z'; upper++) {
      for (char lower = 'a'; lower <= 'z'; lower++) {
        System.out.println(upper + "_" + lower);
        if (lower == 'g') {
          break Outer;
        }
      }
    }
        /*
        A_a
        A_b
        A_c
        A_d
        A_e
        A_f
        A_g
         */

  }
}
