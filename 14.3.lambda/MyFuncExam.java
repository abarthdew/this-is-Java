public class MyFuncExam {
    public static void main(String[] args) {
        
        MyFuncInterface fi;

        fi 
        = () -> { // MyFuncInterface 인터페이스의 익명 구현 객체
            String str = "method call1";
            System.out.println(str);
        };
        fi.method(); // method call1

        fi = () -> { System.out.println("method call2"); };
        fi.method(); // method call2

        fi = () -> System.out.println("method call3");
        fi.method(); // method call3

        // 람다을 사용하지 않고 익명 객체를 만들어 사용했을 경우
        fi = new MyFuncInterface() {
            public void method() {
                System.out.println("method call4");
            };
        };
        fi.method(); // method call4

    }
}
