public class SyncThreadExam {
    public static void main(String[] args) {
        
        Cal125 cal = new Cal125();
        User3 user3 = new User3();
        user3.setCal(cal);
        user3.start(); // setMemory가 동기화 블록이므로 user3이 사용하는 동안은 잠금됨
        // user3이 setMemory 메서드를 다 사용하지 않은 상태, 즉 일시 정지된 상태라 하더라도, user4는 이 메서드 실행 불가

        User4 user4 = new User4();
        user4.setCal(cal);
        user4.start(); // user3이 setMemory 사용을 끝낸 후 user4가 사용 가능
        /*
        User3:100
        User4:50
         */

    }
}
