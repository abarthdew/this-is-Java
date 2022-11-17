public class BoundedParamTypeExam {
    public static void main(String[] args) {
        
        // int reuslt = Util135.compare("a", "b"); // 문자열은 Number의 자식 클래스가 아니므로 이 코드는 잘못된 코드

        int result1 = Util135.compare(10, 20); // Util.<Integer>compare 생략해도 컴파일러가 유추
        // Integer는 Number의 자식 클래스이므로 가능
        System.out.println(result1); // -1

        int result2 = Util135.compare(4.5, 3);
        System.out.println(result2); // 1

    }
}
