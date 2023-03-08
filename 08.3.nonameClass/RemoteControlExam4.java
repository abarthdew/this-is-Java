public class RemoteControlExam4 {
    public static void main(String[] args) {
        
        // 익명 객체 생성: RemoteControl4 인터페이스를 구현하는 클래스를 {}에 선언하겠다
        // -> 클래스를 {}에 생성함과 동시에, 그 클래스의 생성자를 호출해서 (new, ()), 객체를 만들겠다
        RemoteControl4 rc = new RemoteControl4() {

            // 필드와 메서드는 클래스 선언 블록 {} 안쪽에서만 사용됨
            public int volume;

            @Override
            public void turnOn() {
                System.out.println("tv 볼륨 on");
            }

            @Override
            public void turnOff() {
                System.out.println("tv 볼륨 off");
                
            }

            @Override
            public void setVolume(int volume) {
                if(volume > RemoteControl3.MAX_VALUME) {
                    this.volume = RemoteControl3.MAX_VALUME;
                } else if (volume > RemoteControl3.MIM_VOLUME) {
                    this.volume = RemoteControl3.MIM_VOLUME;
                } else {
                    this.volume = volume;
                }
                System.out.println("tv" + this.volume);
            }

            public void otherMethod() {}

        };

        // rc.volume; //에러: 인터페이스에 선언된 것만 호출할 수 있기 때문에, 익명 구현 객체에만 정의된 멤버들은 {} 바깥에서 사용할 수 없음
        rc.turnOff(); // 인터페이스에 선언되어 호출 가능
        // rc.otherMethod(); // 에러: 인터페이스에 선언되어 있지 않음; 익명 구현 객체 선언 블록에만 있음

    }
}