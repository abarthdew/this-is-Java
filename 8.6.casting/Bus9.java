public class Bus9 implements Vehicle9 {
    @Override
    public void run() {
        System.out.println("버스가 달립니다");
    }

    public void checkFare(Vehicle9 vehicle) {
        if (vehicle instanceof Bus9) {
            System.out.println("승차요금 확인합니다");
        } else {
            System.out.println("알맞는 객체가 아님");
        }
    }
}
