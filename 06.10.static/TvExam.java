public class TvExam {
    public static void main(String[] args) {
        System.out.println(Tv.info); // Samsung/LCD

        /*
         * JVM이 이 클래스 내에서 Tv 클래스가 사용된 것을 감지함
         * -> Tv 클래스를 자동으로 메모리에 로딩시킴
         * -> Tv가 가진 정적 필드들이 초기화됨
         * -> Tv의 static 블록이 자동 실행됨
         * -> static 블록 실행 후 Tv.info가 실행됨
         */

        System.out.println(Tv.from1To10Sum); // 45
    }
}
