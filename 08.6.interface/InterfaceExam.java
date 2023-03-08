public class InterfaceExam {
    public static void main(String[] args) {
        ImplementC c = new ImplementC();

        InterfaceA ia = c;
        ia.methodA(); // A에 선언된 메서드만 사용 가능
        
        InterfaceB ib = c;
        ib.methodB(); // B에 선언된 메서드만 사용 가능

        InterfaceC ic = c;
        ic.methodA(); // A, B, C에 선언된 메서드 전부 사용 가능
        ic.methodB();
        ic.methodC();
    }
}
