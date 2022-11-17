public class PareExam {
    public static void main(String[] args) {
        
        Pair<Integer, String> p1 = new Pair<>(1, "사과");
        Pair<Integer, String> p2 = new Pair<>(1, "사과");
        boolean bool1 = Util.<Integer, String>compare(p1, p2);
        boolean bool2 = Util.compare(p1, p2); // 타입 기재를 하지 않을 시 컴파일러가 Pair<Integer, String> 를 기준으로 유추

        System.out.println(bool1); // true
        System.out.println(bool2); // true

        Pair<String, String> p3 = new Pair<>("1", "사과");
        Pair<String, String> p4 = new Pair<>("1", "사과");
        // boolean bool3 = Util.compare(p2, p3); // 컴파일 에러
        boolean bool3 = Util.compare(p3, p4);
        System.out.println(bool3); // true

    }
}
