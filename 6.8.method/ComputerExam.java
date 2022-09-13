public class ComputerExam {
    public static void main(String[] args) {
        Computer com = new Computer();

        int[] values1 = {1,2,3};
        int result1 = com.sum1(values1);
        System.out.println(result1); //6

        int result2 = com.sum1(new int[]{1,2,3});
        System.out.println(result2); //6

        int result3 = com.sum2(1,2,3);
        System.out.println(result3); //6
    }
}
