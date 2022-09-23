public class SmartTv implements RemoteControl5, Searchable{

    private int volume;

    @Override
    public void turnOn() {
        System.out.println("tv를 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("tv를 끕니다");
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
        System.out.println("audio " + this.volume);
    }

    @Override
    public void search(String url) {
        System.out.println(url + " 을 검색합니다");
    }
    
}
