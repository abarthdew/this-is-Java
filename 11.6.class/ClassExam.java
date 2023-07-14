import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExam {
  public static void main(String[] args) throws ClassNotFoundException {

    // 1. 클래스
    Car116 car = new Car116();
    Class clazz1 = car.getClass();
    System.out.println(clazz1.getName()); // Car116 // 원래 패키지명 포함인데 귀찮아서 패키지 안 만들어서 이렇게 나옴
    System.out.println(clazz1.getSimpleName()); // Car116
    // System.out.println(clazz1.getPackage().getName());
    System.out.println();

    try {
      Class clazz2 = Class.forName("Car116");
      System.out.println(clazz2.getName()); // Car116
      System.out.println(clazz2.getSimpleName()); // Car116
      // System.out.println(clazz2.getPackage().getName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }


    // 2. 리플랙션
    Class clazz3 = Class.forName("Car116");
    System.out.println(clazz3.getName()); // 클래스 이름
    // 생성자 정보
    Constructor[] cons = clazz3.getDeclaredConstructors();
    for (Constructor con : cons) {
      System.out.print(con.getName() + "(");
      Class[] params = con.getParameterTypes();
      printParam(params);
      System.out.println(")");
            /*
            // Car116의 생성자 리턴
            Car116()
            Car116(java.lang.String)
             */
    }

    System.out.println();

    // 필드 정보 출력
    Field[] fields = clazz3.getDeclaredFields();
    for (Field field : fields) {
      System.out.println(field.getType().getSimpleName() + " " + field.getName());
            /*
            String model
            String owner
             */
    }

    System.out.println();

    // 메서드 정보 출력
    Method[] methods = clazz3.getDeclaredMethods();
    for (Method method : methods) {
      System.out.print(method.getReturnType().getSimpleName() + " "); // 리턴 타입
      System.out.print(method.getName() + "(");
      Class[] params = method.getParameterTypes();
      printParam(params);
      System.out.println(")");
            /*
            String getOwner()
            void setModel(java.lang.String)
            void setOwner(java.lang.String)
            String getModel()
             */
    }

  }

  private static void printParam(Class[] params) {
    for (int i = 0; i < params.length; i++) {
      System.out.print(params[i].getName());
      if (i < (params.length - 1)) {
        System.out.print(",");
      }
    }
  }
}