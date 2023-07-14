import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit155> {

  @Override
  public int compare(Fruit155 o1, Fruit155 o2) { // 내림차순 정렬
    if (o1.price < o2.price) return 1;
    else if (o1.price == o2.price) return 0;
    else return -1;
  }

}
