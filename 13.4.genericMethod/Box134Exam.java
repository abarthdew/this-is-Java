public class Box134Exam {
    public static void main(String[] args) {
        
        // Util.<Integer>boxing("홍길동"); // 컴파일 에러

        Box134<Integer> box1 = Util.<Integer>boxing(100);
        System.out.println(box1); // Box134@15db9742 (Box 객체)

        Integer val1 = box1.getT();
        System.out.println(val1); // 100

        Box134 box2 = Util.boxing("홍길동"); // 구체적 타입을 주지 않을 경우, 컴파일러는 유추해서 판단(이 경우 String으로 유추)
        String val2 = (String) box2.getT();
        System.out.println(val2); // 홍길동

        Box134<String> box3 = Util.boxing("홍길동");
        String val3 = box3.getT();
        System.out.println(val3); // 홍길동

    }
}
