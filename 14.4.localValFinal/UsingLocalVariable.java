public class UsingLocalVariable {
    
    void method(int arg) {
        int localVar = 40;

        // arg = 31; // 컴파일 오류: final 특성을 가지므로 값 수정 불가
        // localVar = 41; // 컴파일 오류: final 특성을 가지므로 값 수정 불가
    
        MyFunc5Interface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };
        fi.method();
    }

}
