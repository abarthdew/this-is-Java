public class Singleton {
  // 애플리케이션 전체에서 싱글톤 객체는 딱 하나만 만들어짐
  private static Singleton singleton = new Singleton();

  private Singleton() {

  }

  static Singleton getInstance() {
    return singleton;
  }
}