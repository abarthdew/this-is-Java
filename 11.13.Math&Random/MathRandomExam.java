public class MathRandomExam {
  public static void main(String[] args) {

    // 주사위 눈 무작위로 얻기
    int num = (int) (Math.random() * 6) + 1;
    System.out.println(num); // 2 // 1~6 사이 무작위 수

  }
}
