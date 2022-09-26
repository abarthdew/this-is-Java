public class NestedLocalClass {
    
    // java 7 이전
    public void method1 (final int arg) {
        final int localVariable = 1;
        class Inner {
            void method() {
                // final 키워드를 붙이게 되면 아래와 같이 지역 변수로 간주함(값 변경 불가)
                /*
                (참고용)
                 int arg = 10;
                 int localVariable = 1;
                 */
                int result = arg + localVariable;
            }
        }
    }

    // java 8 이후
    public void method2 (int arg) {
        int localVariable = 1;
        class Inner {
            // final 키워드를 붙이지 않아도 컴파일러가 알아서 해석, 아래와 같이 로컬 클래스 Inner의 필드로 간주함(값 변경 불가)
            /*
            (참고용)
             int arg = 10;
             int localVariable = 1;
             */
            void method() {
                int result = arg + localVariable;
            }
        }
    }
}
