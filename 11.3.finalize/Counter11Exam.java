public class Counter11Exam {
    public static void main(String[] args) {
        Counter11 counter = null;
        for (int i=0; i<50; i++) {
            counter = new Counter11(i);
            counter = null; // 만들자마자 쓰레기 객체로 만들기
            System.gc(); // JVM에게 가급적으로 가비지 컬렉터를 빨리 실행하도록 명령 -> 쓰레기 객체 수거
            /*
             0번 객체의 finalize()가 실행됨
            6번 객체의 finalize()가 실행됨
            9번 객체의 finalize()가 실행됨
            12번 객체의 finalize()가 실행됨
            15번 객체의 finalize()가 실행됨
            18번 객체의 finalize()가 실행됨
            19번 객체의 finalize()가 실행됨
            22번 객체의 finalize()가 실행됨
            25번 객체의 finalize()가 실행됨
            29번 객체의 finalize()가 실행됨
            33번 객체의 finalize()가 실행됨
            36번 객체의 finalize()가 실행됨
            40번 객체의 finalize()가 실행됨
            44번 객체의 finalize()가 실행됨
            43번 객체의 finalize()가 실행됨
            42번 객체의 finalize()가 실행됨
            45번 객체의 finalize()가 실행됨
            49번 객체의 finalize()가 실행됨
            48번 객체의 finalize()가 실행됨
            47번 객체의 finalize()가 실행됨
             */
            // 가비지 컬렉터가 무작위로 선택해서 객체를 제거함을 알 수 있음
        }
    }
}
