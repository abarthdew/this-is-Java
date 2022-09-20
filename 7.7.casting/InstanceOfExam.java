public class InstanceOfExam {
    
    public static void method1(Parent2 parent) {
        if (parent instanceof Child2) {
            Child2 child = (Child2) parent;
            System.out.println("method1 - child로 변환 성공");
        } else {
            System.out.println("method1 - child로 변환되지 않음");
        }
    }

    public static void method2(Parent2 parent) {
        Child2 child = (Child2) parent;
        System.out.println("method2 - child로 변환 성공");
    }

    public static void main(String[] args) {
        Parent2 parentA = new Child2();
        method1(parentA); // method1 - child로 변환 성공
        method2(parentA); // method2 - child로 변환 성공

        Parent2 parentB = new Parent2();
        method1(parentB); // method1 - child로 변환되지 않음
        method2(parentB); // 강제 타입 변환 예외 발생
    }

}
