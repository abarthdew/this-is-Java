import java.util.function.Predicate;

public class PredicateIsEqual {
    public static void main(String[] args) {
        
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null: " + predicate.test(null)); // null, null: true

        predicate = Predicate.isEqual("java8");
        System.out.println("null, java8: " + predicate.test(null)); // ull, java8: false

        predicate = Predicate.isEqual(null);
        System.out.println("null, java8: " + predicate.test("java8")); // null, java8: false

        predicate = Predicate.isEqual("java8");
        System.out.println("java8, java8: " + predicate.test("java8")); // java8, java8: true

    }
}
