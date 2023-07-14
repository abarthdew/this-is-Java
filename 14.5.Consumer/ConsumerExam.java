import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExam {
  public static void main(String[] args) {

    Consumer<String> consumer = t -> System.out.println(t + "8");
    consumer.accept("java"); // java8

    BiConsumer<String, String> bi = (t, u) -> System.out.println(t + u);
    bi.accept("java", "8"); // java8

    DoubleConsumer db = d -> System.out.println("java" + d);
    db.accept(8.0); // java8.0

    ObjIntConsumer<String> obj = (t, i) -> System.out.println(t + i);
    obj.accept("java", 8); // java8

  }
}
