public interface RemoteControl4 {
    int MAX_VALUME = 10;
    int MIM_VOLUME = 0;

    // public abstract void turnOn(); 와 같음: public abstract가 생략되어 있어도 컴파일 과정에서 자동으로 붙음
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    // default 메서드: 자바 8부터 가능
    default void setMute(boolean mute) {
        if(mute) {
            System.out.println("무음 처리");
        } else {
            System.out.println("무음 해제");
        }
    }

    // static 메서드: 자바 8부터 가능
    static void changeBattery() {
        System.out.println("건전지 교환");
    }
}
