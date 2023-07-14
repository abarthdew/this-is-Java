public class RuntimeException {
  public static void main(String[] args) {

    // 1. NullPointException
    String data = null; // 일반 예외가 아니라 실행 예외이기 때문에, 일단 컴파일까지는 시켜 줌
    // System.out.println(data.toString());
        /*
        Exception in thread "main" java.lang.NullPointerException
        at RuntimeException.main(RuntimeException.java:5)
         */

    // 2. ArrayIndexOutOfBoundsException
    String data1 = args[0];
    // System.out.println(data1);
        /*
         Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        at RuntimeException.main(RuntimeException.java:13) 
         */

    // 3. NumberFormatException
    String data2 = "100";
    String data3 = "a100";
    int value1 = Integer.parseInt(data2);
    int value2 = Integer.parseInt(data3);
    System.out.println(data2);
    System.out.println(data3);
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        at RuntimeException.main(RuntimeException.java:13) 
         */

    // 4. ClassCastException
    Animal animal = new Dog();
    Dog dog = (Dog) animal;
    Cat cat = (Cat) animal; // 예외

    changeDog(new Dog());
    changeDog(new Cat()); // 예외

  }

  public static void changeDog(Animal animal) {
    Dog dog = (Dog) animal;
  }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}