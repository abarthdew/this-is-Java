public class Vehicle9Exam {
  public static void main(String[] args) {

    Vehicle9 v = new Bus9();
    v.run(); // 버스가 달립니다
    // v.checkFare(); // 컴파일 에러: 인터페이스에 선언된 것만 사용 가능

    Bus9 bus = (Bus9) v; // 강제 타입 변환
    bus.run(); // 버스가 달립니다
    bus.checkFare(bus); // 승차요금 확인합니다

    // instanceof로 객체 검증
    Taxi9 taxi = new Taxi9();
    bus.checkFare(taxi); // 알맞는 객체가 아님
  }
}
