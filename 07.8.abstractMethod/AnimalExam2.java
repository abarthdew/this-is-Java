public class AnimalExam2 {
  public static void main(String[] args) {
    Dog2 dog = new Dog2();
    Cat2 cat = new Cat2();

    dog.sound(); // 멍멍
    cat.sound(); // 냥냥

    Animal2 animal = null;
    animal = new Dog2();
    animal.sound(); // 멍멍 // 자식 객체가 부모 타입으로 변환이 되어도, 메서드가 재정의되면 자식 메서드가 호출됨

    animal = new Cat2();
    animal.sound(); // 냥냥

    animalSound(new Dog2()); // 멍멍
    animalSound(new Cat2()); // 냥냥
  }

  public static void animalSound(Animal2 animal) { // 자식 객체인 Dog2, Cat2가 Animal2 타입으로 들어올 경우
    animal.sound(); // 자식 객체의 재정의된 메서드가 호출됨
  }
}
