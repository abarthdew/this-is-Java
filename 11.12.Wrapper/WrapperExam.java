public class WrapperExam {
  public static void main(String[] args) {

    // Boxing
    Integer obj1 = new Integer(100);
    Integer obj2 = new Integer("100");
    Integer obj3 = Integer.valueOf(100);
    Integer obj4 = Integer.valueOf("100");

    System.out.println(obj1); // 100
    System.out.println(obj2); // 100
    System.out.println(obj3); // 100
    System.out.println(obj4); // 100

    // UnBoxing
    int value1 = obj1.intValue();
    int value2 = obj2.intValue();
    int value3 = obj3.intValue();
    int value4 = obj4.intValue();

    System.out.println(value1); // 100
    System.out.println(value2); // 100
    System.out.println(value3); // 100
    System.out.println(value4); // 100

    // auto Boxing
    Integer obj5 = 100;
    System.out.println(obj5); // 100
    System.out.println(obj5.intValue()); // 100

    // auto UnBoxing
    int value5 = obj5; // value5는 int 기본타입, obj는 Integer 객체지만, 대입되는 순간 자동 언박싱됨
    System.out.println(value5); // 100

    // 연산 시 자동 UnBoxing
    int result = obj5 + 100; // 객체 + 100 = 자동 언박싱된 객체(obj5) + 100
    System.out.println(result); // 200
    // 1. 객체가 기본 타입에 대입이 될 때
    // 2. 객체가 연산이 될 때
    // => 이 객체는 반드시 Wrapper 객체가 되어야 언박싱 가능

  }
}