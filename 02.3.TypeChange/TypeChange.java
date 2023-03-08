public class TypeChange {
    public static void main(String[] args) {
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println(intValue); // 10

        char charValue = '가';
        intValue = charValue;
        System.out.println(intValue); // 44032

        intValue = 500;
        long longValue = intValue;
        System.out.println(longValue); // 500 

        intValue = 200;
        double doubleValue = intValue;
        System.out.println(doubleValue); // 200.0

        longValue = 1000000000000000L;
        float floatValue = longValue; // 부동 소수점 방식으로 저장되기 때문에, float(4byte) < long(8byte), float에 더 큰 값 저장 가능
    }
}