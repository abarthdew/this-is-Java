public class MyFunc2Exam {
  public static void main(String[] args) {

    MyFunc2Interface fi;

    fi = (x) -> {
      int result = x * 5;
      System.out.println(result);
    };
    fi.method(2); // 10

    fi = (x) -> {
      System.out.println(x * 5);
    };
    fi.method(2); // 10

    fi = (x) -> System.out.println(x * 5);
    fi.method(2); // 10

    fi = x -> System.out.println(x * 5);
    fi.method(2); // 10

    MyFunc3Interface fi3;
    fi3 = (x, y) -> {
      int result = x + y;
      return result;
    };
    System.out.println(fi3.method(2, 5)); // 7

    fi3 = (x, y) -> {
      return x + y;
    };
    System.out.println(fi3.method(2, 5)); // 7

    fi3 = (x, y) -> x + y;
    System.out.println(fi3.method(2, 5)); // 7

    fi3 = (x, y) -> sum(x, y);
    System.out.println(fi3.method(2, 5)); // 7

  }

  public static int sum(int x, int y) {
    return x + y;
  }

}
