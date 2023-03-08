public class ComputerExam {
    public static void main(String[] args) {
        int r = 10;
        Calculator2 calculator = new Calculator2();
        System.out.println(calculator.areaCircle(r));
        /*
         Calculator 객체의 areaCircle() 실행
        314.1592653589793
         */

        Computer2 computer = new Computer2();
        System.out.println(computer.areaCircle(r));
        /*
         Computer 객체의 areaCircle() 실행
        314.1592653589793
         */
    }
}
