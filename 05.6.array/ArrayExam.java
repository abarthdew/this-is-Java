public class ArrayExam {
  public static void main(String[] args) {
    int[] score = {83, 87, 90};
    // heap영역에 생성된 {83, 87, 90} 객체의 번지가 stack영역의 score 변수에 저장됨

    System.out.println(score[0]); // 83
    System.out.println(score[1]); // 87
    System.out.println(score[2]); // 90

    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += score[i];
    }
    System.out.println("총합: " + sum); // 총합: 260

    double avg = (double) sum / 3;
    System.out.println("평균: " + avg); // 평균: 86.66666666666667

    int[] score2;
    // scroe2 = {83, 87, 90}; // 변수 선언 후 값 대입할 땐 이렇게 할 수 없음
    score2 = new int[]{83, 87, 90};
    int sum2 = 0;
    for (int i = 0; i < 3; i++) {
      sum2 += score2[i];
    }
    System.out.println("총합: " + sum2); // 총합: 260

    double avg2 = (double) sum2 / 3;
    System.out.println("평균: " + avg2); //평균: 86.66666666666667

    // add({83, 90, 87}); 컴파일 에러 - 배열 객체를 대입해야 함
    int sum3 = add(new int[]{83, 90, 87}); // 배열 객체 대입
    System.out.println(sum3); // 260
  }

  public static int add(int[] scores) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += scores[i];
    }
    return sum;
  }
}