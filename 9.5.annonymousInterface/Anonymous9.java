public class Anonymous9 {
    // 1. 필드의 초기값으로 익명 구현 객체 대입
    RemoteControl9 field = new RemoteControl9() {

        @Override
        public void turnOn() {
            System.out.println("tv 켭니다");
        }

        @Override
        public void turnOff() {
            System.out.println("tv 끕니다");
        }

    };

    // 2. 로컬 변수에 익명 구현 객체 대입
    void method1() {
        RemoteControl9 localVar = new RemoteControl9() {

            @Override
            public void turnOn() {
                System.out.println("audio 켭니다");
            }
    
            @Override
            public void turnOff() {
                System.out.println("audio 끕니다");
            }
    
        };
        localVar.turnOn();
        localVar.turnOff();
    }

    // 3. 메서드의 매개변수로 익명 구현 객체 호출
    void method2(RemoteControl9 rc) {
        rc.turnOn();
        rc.turnOff();
    }
}
