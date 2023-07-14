public class Computer2 extends Calculator2 {
  // override 단축기: ctrl + space
  @Override
  double areaCircle(double r) {
    System.out.println("Computer 객체의 areaCircle() 실행");
    return Math.PI * r * r;
  }
}
