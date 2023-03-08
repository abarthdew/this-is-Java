public class RemoteControl3Exam {
    public static void main(String[] args) {
        
        RemoteControl3 rc;
        // rc = new RemoteControl3(); // 인터페이스를 직접 생성할 수 없음
        rc = new Television3(); // 인터페이스 변수에 대입되는 것은 항상 구현 객체만 가능
        rc = new Audio3(); // 구현 객체의 생성 번지가 인터페이스 변수에 저장됨

        // 인터페이스에 선언된 여러가지 메서드 사용 가능
        // 개발 코드
        rc.turnOn(); // audio 볼륨 on // 인터페이스의 메서드를 호출함으로서 구현 객체의 실제 재정의된 메서드가 호출됨
        rc.turnOff(); // audio 볼륨 off
    }
}
