public class MainThreadExam {
    public static void main(String[] args) {
        
        Cal124 cal = new Cal124();
        User1 user1 = new User1();
        user1.setCal(cal);
        user1.start(); // 이것만 실행했을 때는 user1: 100이 나옴

        User2 user2 = new User2();
        user2.setCal(cal);
        user2.start(); // 이 시점에서 user1, 2를 동시에 실행했을 때, 두 스레드가 같은 객체를 공유하므로 출력 결과는 다음과 같음
        /*
        User2:50
        User1:50
         */

    }
}
