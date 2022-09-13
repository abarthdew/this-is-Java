public class CarExam {
    public static void main(String[] args) {
        Car car = new Car();

        car.setGas(5);
        boolean gasState = car.isLeftGas();
        if (gasState) {
            System.out.println("출발합니다.");
            car.run();
        }

        /*
         gas가 있습니다
        출발합니다.
        달립니다. gas잔량: 5
        달립니다. gas잔량: 4
        달립니다. gas잔량: 3
        달립니다. gas잔량: 2
        달립니다. gas잔량: 1
        멈춥니다. gas잔량: 0
        gas가 없습니다
         */

        if(car.isLeftGas()) {
            System.out.println("gas를 주입할 필요가 없습니다.");
        } else {
            System.out.println("gas를 주입하세요.");
        }
        // gas를 주입하세요.
    }
}
