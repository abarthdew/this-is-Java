public class AnonymousExam {
    public static void main(String[] args) {
        
        Anonymous a = new Anonymous();
        a.field.wake(); // 익명 자식 객체의 재정의된 메서드가 실행됨
        /*
         6시에 일어납니다
        출근합니다  
         */

        a.method1();
        /*
         9시에 일어납니다
        산책합니다
         */

        a.method2(new Person9() { // 익명 자식 객체 대입
            String studentNo; // 새로운 필드
            void study() { // 새로운 메서드
                System.out.println("공부합니다");
            }
            @Override
            void wake() { // 재정의된 메서드
                System.out.println("11시에 일어납니다");
                study(); 
            }
        });
        /*
         11시에 일어납니다
        공부합니다
         */
    }
}
