public class Tire2 {
    public int maxRotation; // 타이어 최대 회전수
    public int accumulatedRotation; // 누적 회전수
    public String location; // 타이어 위치

    public Tire2(String location, int maxRotation) {
        this.location = location;
        this.maxRotation = maxRotation;
    }

    public boolean roll() { // 타이어 굴러감
        ++accumulatedRotation; // 한번 회전할 때마다 + 1
        if (accumulatedRotation < maxRotation) { // 누적 회전수 < 최대 회전수
            System.out.println(location + "Tire의 남은 수명: " + (maxRotation - accumulatedRotation));
            return true;
        } else {
            System.out.println("** " + location + "Tire 수명 종료");
            return false;
        }
    }
}
