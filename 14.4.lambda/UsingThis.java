public class UsingThis {
    
    public int outterField = 10;

    class Inner {
        int innerField = 20;

        void method() { // Inner의 메서드
            MyFunc144Interface fi = () -> {
                System.out.println("outterField: " + outterField); // 바깥 클래스의 필드를 사용할 수 있음
                System.out.println("innerField: " + innerField);
            };
            fi.method(); // MyFunc144Interface의 메서드
        }
    }

}
