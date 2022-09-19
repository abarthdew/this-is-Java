public class KumhoTire2 extends Tire2{

    public KumhoTire2(String location, int maxRotation) {
        super(location, maxRotation);
    }

    @Override
    public boolean roll() { // 타이어 굴러감
        ++accumulatedRotation; // 한번 회전할 때마다 + 1
        if (accumulatedRotation < maxRotation) { // 누적 회전수 < 최대 회전수
            System.out.println(location + "HankookTire의 남은 수명: " + (maxRotation - accumulatedRotation));
            return true;
        } else {
            System.out.println("** " + location + "HankookTire 수명 종료");
            return false;
        }
    }
}
