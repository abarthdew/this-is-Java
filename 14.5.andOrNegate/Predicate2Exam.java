import java.util.function.IntPredicate;

public class Predicate2Exam {
    public static void main(String[] args) {
        
        // 2의 배수 검사
        IntPredicate pA = a -> a%2 == 0;

        // 3의 배수 검사
        IntPredicate pB = a -> a%3 == 0;

        IntPredicate pAB;
        boolean result;

        // and
        pAB = pA.and(pB);
        result = pAB.test(9);
        System.out.println("result는 2와 3의 배수인가?: " + result); // result는 2와 3의 배수인가?: fals

        // or
        pAB = pA.or(pB);
        result = pAB.test(9);
        System.out.println("result는 2또는 3의 배수인가?: " + result); // result는 2또는 3의 배수인가?: true

        // negate
        pAB = pA.negate();
        result = pAB.test(9);
        System.out.println("!(result는 2의 배수인가?): " + result); // !(result는 2의 배수인가?): true
    }
}
