public class UsingThis2 {
    
    public int field = 10; // 필드 이름이 동일한 경우

    class Inner {
        int field = 20; // 필드 이름이 동일한 경우

        void method() { 
            MyFunc144Interface fi = () -> {
                System.out.println("outterField: " + UsingThis2.this.field);
                System.out.println("innerField: " + this.field);
                System.out.println("구분을 안 한다면: " + field);
            };
            fi.method();
        }
    }

}
