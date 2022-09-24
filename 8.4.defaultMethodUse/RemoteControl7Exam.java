public class RemoteControl7Exam {
    public static void main(String[] args) {
        
        RemoteControl7 rc = null;

        rc = new Television7();
        
        // 구현 객체가 인터페이스 변수에 대입된 후에야 default 메서드 호출 가능
        rc.setVolume(5); // 구현객체 Tv의 setVolumn

        rc = new Audio7();
        rc.setMute(true); // 구현객체 Audio의 setMute
    }
}
