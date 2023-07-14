public class TireExam2 {
  public static void main(String[] args) {

    CarTire2 car = new CarTire2();

    for (int i = 1; i <= 5; i++) {
      int problemLocation = car.run();
      if (problemLocation != 0) { // 타이어가 펑크일 경우
        System.out.println(car.tires[problemLocation - 1].location + "HankookTire로 교체");
        car.tires[problemLocation - 1] = new HankookTire2(car.tires[problemLocation - 1].location, 15); // 자식객체로 변환
      }
      System.out.println("-----------------");
    }
        /*
         --자동차가 달립니다.--
        앞왼쪽Tire의 남은 수명: 5
        앞오른쪽Tire의 남은 수명: 1
        뒤왼쪽Tire의 남은 수명: 2
        뒤오른쪽Tire의 남은 수명: 3
        -----------------
        --자동차가 달립니다.--
        앞왼쪽Tire의 남은 수명: 4
        ** 앞오른쪽Tire 수명 종료
        --자동차가 멈춥니다.--
        앞오른쪽HankookTire로 교체
        -----------------
        --자동차가 달립니다.--
        앞왼쪽Tire의 남은 수명: 3
        앞오른쪽HankookTire의 남은 수명: 14
        뒤왼쪽Tire의 남은 수명: 1
        뒤오른쪽Tire의 남은 수명: 2
        -----------------
        --자동차가 달립니다.--
        앞왼쪽Tire의 남은 수명: 2
        앞오른쪽HankookTire의 남은 수명: 13
        ** 뒤왼쪽Tire 수명 종료
        --자동차가 멈춥니다.--
        뒤왼쪽HankookTire로 교체
        -----------------
        --자동차가 달립니다.--
        앞왼쪽Tire의 남은 수명: 1
        앞오른쪽HankookTire의 남은 수명: 12
        뒤왼쪽HankookTire의 남은 수명: 14
        뒤오른쪽Tire의 남은 수명: 1
        -----------------
         */

  }
}
