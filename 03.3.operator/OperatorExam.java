public class OperatorExam {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;

        x++;
        ++x;
        System.out.println(x); // 12

        y--;
        --y;
        System.out.println(y); // 8

        z = x++;
        System.out.println(z); // 12
        System.out.println(x); // 13
        z = ++x;
        System.out.println(z); // 14
        System.out.println(x); // 14

        z = ++x + y++;
        System.out.println(z); // 15 + 8 = 23
        System.out.println(y); // 9

    }
}
