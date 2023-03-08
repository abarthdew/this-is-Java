public class Car8Exam {
    public static void main(String[] args) {
        
        Car8 car = new Car8();
        car.run();
        /*
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
         */

        car.frontLeftTire = new KumhoTire8();
        car.frontRightTire = new KumhoTire8();

        car.run();
        /*
         금호 타이어가 굴러갑니다
        금호 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
         */

    }
}
