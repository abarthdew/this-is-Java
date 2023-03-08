public class CompareOperator {
    public static void main(String[] args) {
        char char1 = 'A'; // 65
        char char2 = 'B'; // 66
        System.out.println(char1 < char2); // true

        int v2 = 1;
        double v3 = 1.0;
        System.out.println(v2 == v3); // true

        double v4 = 0.1;
        float v5 = 0.1f;
        System.out.println(v4 == v5); // false: 둘의 정밀도 사이에 차이가 있기 때문에 다르다고 해석
        System.out.println((float)v4 == v5); // true
        System.out.println((int)(v4*10) == (int)(v5*10)); // true
    }
}
