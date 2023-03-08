public class Audio7 implements RemoteControl7 {

    int volume;

    @Override
    public void turnOn() {
        System.out.println("audio 볼륨 on");
    }

    @Override
    public void turnOff() {
        System.out.println("audio 볼륨 off");
        
    }

    @Override
    public void setMute(boolean mute) {
        System.out.println("구현객체 Audio의 setMute"); 
    }
}
