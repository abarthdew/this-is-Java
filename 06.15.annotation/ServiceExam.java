import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceExam {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method[] defalredMethods = Service.class.getDeclaredMethods(); // Service 클래스의 메서드를 배열로 리턴

        // 메서드 이름 출력
        for (Method method : defalredMethods) {
            System.out.println(method.getName()); // 메서드 이름 출력
            /*
             method2
            method1
            method3
             */
        }

        // 메서드에 특정 어노테이션 적용 여부 판별
        for (Method method : defalredMethods) {
            if (method.isAnnotationPresent(PrintAnnotation.class)) { // printAnnotation이 메서드에 적용되어 있는가?
                System.out.println(method.getName() + " 에 적용됨");
            } else {
                System.out.println(method.getName() + " 에는 적용되지 않음");
            }
            /*
             method1 에 적용됨
            method2 에 적용됨
            method3 에 적용됨
             */
        }

        // 메서드에 적용된 어노테이션 필드 출력하기
        for (Method method : defalredMethods) {
            if (method.isAnnotationPresent(PrintAnnotation.class)) {
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class); // method에 적용된 어노테이션 객체 얻기
                System.out.print(method.getName() + " : " + printAnnotation.value() + " / ");
                System.out.println(printAnnotation.number());
            }
            /*
            method2 : * / 15
            method1 : - / 15
            method3 : # / 20
             */
        }

        // 어노테이션을 사용해 구분선 출력하기
        for (Method method : defalredMethods) {
            if (method.isAnnotationPresent(PrintAnnotation.class)) {
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class); // method에 적용된 어노테이션 객체 얻기
                System.out.print(method.getName() + " : ");
                for (int i=0; i<printAnnotation.number(); i++) {
                    System.out.print(printAnnotation.value());
                }
                System.out.println();
            }
            /*
            method1 : ---------------
            method3 : ####################
            method2 : ***************
             */
        }

        // 어노테이션이 적용된 메서드 호출
        for (Method method : defalredMethods) {
            if (method.isAnnotationPresent(PrintAnnotation.class)) {
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class); // method에 적용된 어노테이션 객체 얻기
                
                // 어노테이션을 사용해 구분선 출력
                for (int i=0; i<printAnnotation.number(); i++) {
                    System.out.print(printAnnotation.value());
                }
                System.out.println();

                // 메서드 호출
                method.invoke(new Service()); // Service 객체를 매개로 모든 메서드를 불러냄 - service.method1, 2, 3()와 같은 표현식
            }
            /*
            ***************
            실행 내용2
            ####################
            실행 내용3
            ---------------
            실행 내용1
             */
        }
    }
}
