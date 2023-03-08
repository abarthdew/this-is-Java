public interface RemoteControl7 {
    int MAX_VALUME = 10;
    int MIM_VOLUME = 0;
    void turnOn();
    void turnOff();

    // default 메서드 선언
    default void setVolume(int volume) {
        System.out.println("인터페이스의 setVolumn");
    }

    // default 메서드 선언
    default void setMute(boolean mute) {
        System.out.println("인터페이스의 setMute");
    }
}
