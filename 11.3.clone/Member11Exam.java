public class Member11Exam {
  public static void main(String[] args) {

    // 1. 얕은 복사
    Member11 original = new Member11("blue", "홍길동", "12345", 25, true, new Car12("k5"));
    Member11 cloned = original.getMember(); // 얕은 복사
    // original과 cloned는 다른 객체지만, 내부 데이터는 같음

    System.out.println("원본 객체의 필드값");
    System.out.println(original.id); // blue
    System.out.println(original.name); // 홍길동
    System.out.println(original.password); // 12345
    System.out.println(original.age); // 25
    System.out.println(original.adult); // true
    System.out.println(original.car.model); // k5

    System.out.println("복제된 객체의 필드값");
    System.out.println(cloned.id); // blue
    System.out.println(cloned.name); // 홍길동
    System.out.println(cloned.password); // 12345
    System.out.println(cloned.age); // 25
    System.out.println(cloned.adult); // true
    System.out.println(cloned.car.model); // k5

    cloned.name = "홍길동2";
    System.out.println(original.name); // 홍길동
    System.out.println(cloned.name); // 홍길동2
    // 복제 객체의 필드를 변경해도 원본 객체의 필드는 바뀌지 않음

    cloned.car.model = "포르쉐";
    System.out.println(original.car.model); // 포르쉐
    System.out.println(cloned.car.model); // 포르쉐
    // 복제 객체의 참조 필드를 변경하면 원본 객체의 참조 필드도 바뀜(같은 객체를 가리키고 있으므로)


    // 2. 깊은 복사
    Member12 original2 = new Member12("홍길순", 26, new int[]{90, 91}, new Car12("소나타"));
    Member12 cloned2 = original2.getMember();
    System.out.println("원본 객체의 필드값");
    System.out.println(original2.name); // 홍길순
    System.out.println(original2.age); // 26
    for (int val : original2.score) {
      System.out.println(val);
            /*
            90
            91  
             */
    }
    System.out.println(original2.car.model); // 소나타

    System.out.println("복제된 객체의 필드값");
    System.out.println(cloned2.name); // 홍길순
    System.out.println(cloned2.age); // 26
    for (int val : cloned2.score) {
      System.out.println(val);
            /*
            90
            91  
             */
    }
    System.out.println(cloned2.car.model); // 소나타

    // 깊은 복사한 객체가 같은지 검증
    cloned2.score[0] = 100;
    cloned2.car.model = "그랜져";
    for (int val : original2.score) {
      System.out.println(val);
            /*
            90
            91  
             */
    }
    for (int val : cloned2.score) {
      System.out.println(val);
            /*
            100
            91  
             */
    }
    System.out.println(original2.car.model); // 소나타
    System.out.println(cloned2.car.model); // 그랜져
  }
}
