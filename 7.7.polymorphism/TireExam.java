public class TireExam {
    public static void main(String[] args) {
        
        CarTire car = new CarTire();

        for(int i=1; i<=5; i++) {
            int problemLocation = car.run();
            switch(problemLocation) {
                case 1:
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    car.frontLeftTire = new HankookTire("앞왼쪽", 15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    car.frontLeftTire = new KumhoTire("앞오른쪽", 13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 HankookTire로 교체");
                    car.frontLeftTire = new HankookTire("뒤왼쪽", 14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 KumhoTire로 교체");
                    car.frontLeftTire = new KumhoTire("뒤오른쪽", 17);
                    break;
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
        앞오른쪽 KumhoTire로 교체
        -----------------
        --자동차가 달립니다.--
        앞오른쪽HankookTire의 남은 수명: 12
        ** 앞오른쪽Tire 수명 종료
        --자동차가 멈춥니다.--
        앞오른쪽 KumhoTire로 교체
        -----------------
        --자동차가 달립니다.--
        앞오른쪽HankookTire의 남은 수명: 12
        ** 앞오른쪽Tire 수명 종료
        --자동차가 멈춥니다.--
        앞오른쪽 KumhoTire로 교체
        -----------------
        --자동차가 달립니다.--
        앞오른쪽HankookTire의 남은 수명: 12
        ** 앞오른쪽Tire 수명 종료
        --자동차가 멈춥니다.--
        앞오른쪽 KumhoTire로 교체
        -----------------
         */

    }
}
