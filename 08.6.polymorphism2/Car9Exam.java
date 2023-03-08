public class Car9Exam {
    public static void main(String[] args) {
        
        Car9 car = new Car9();
        car.run();
        /*
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
         */

        car.tires[0] = new KumhoTire9();
        car.tires[1] = new KumhoTire9();

        car.run();
        /*
         금호 타이어가 굴러갑니다
        금호 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
        한국 타이어가 굴러갑니다
         */

    }
}
