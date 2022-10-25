public class Wrapper2Exam {
    public static void main(String[] args) {
        
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println(value1); // 10
        System.out.println(value2); // 3.14
        System.out.println(value3); // true

        System.out.println("-128~127 초과값일 경우: ");
        Integer obj1 = 300; // 자동 박싱 발생, 새로운 Integer 객체 생성
        Integer obj2 = 300; // 자동 박싱 발생, 새로운 Integer 객체 생성
        System.out.println(obj1 == obj2); // false // 객체 번지 비교
        System.out.println(obj1.equals(obj2)); // true // 객체 내 값 비교

        System.out.println("-128~127 범위값일 경우: ");
        Integer obj3 = 10; // 자동 박싱 발생, 새로운 Integer 객체 생성
        Integer obj4 = 10; // 자동 박싱 발생, 새로운 Integer 객체 생성
        System.out.println(obj3 == obj4); // true // 객체 번지 비교: -128~127 범위값일 경우 Integer 객체는 하나만 만들어져서 공유됨
        System.out.println(obj3.equals(obj4)); // true // 객체 내 값 비교

    }
}
