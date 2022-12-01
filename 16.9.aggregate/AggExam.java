import java.util.Arrays;

public class AggExam {
    public static void main(String[] args) {
        
        long count = Arrays.stream(new int[]{1,2,3,4,5})
            .filter(n->n%2==0)
            .count();
        System.out.println("2의 배수 개수: " + count); // 2의 배수 개수: 2

        long sum = Arrays.stream(new int[]{1,2,3,4,5})
            .filter(n->n%2==0)
            .sum();
        System.out.println("2의 배수 합: " + sum); // 2의 배수 합: 6

        int min = Arrays.stream(new int[]{1,2,3,4,5})
            .filter(n->n%2==0)
            .min()
            .getAsInt();
        System.out.println("최소값: " + min); // 최소값: 2

        int max = Arrays.stream(new int[]{1,2,3,4,5})
            .filter(n->n%2==0)
            .max()
            .getAsInt();
        System.out.println("최대값: " + max); // 최대값: 4

        int first = Arrays.stream(new int[]{1,2,3,4,5})
            .filter(n->n%3==0)
            .findFirst()
            .getAsInt();
        System.out.println("첫번째 3의 배수: " + first); // 첫번째 3의 배수: 3

    }
}
