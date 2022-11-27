import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExam {
    public static void main(String[] args) {
        
        try {
            TreeSet<Fruit155> treeSet = new TreeSet<>();
            treeSet.add(new Fruit155("포도", 3000));
            treeSet.add(new Fruit155("딸기", 13000));
            treeSet.add(new Fruit155("수박", 6000));

            Iterator<Fruit155> iterator = treeSet.iterator();

            while(iterator.hasNext()) {
                Fruit155 fruit = iterator.next();
                System.out.println(fruit.name + " : " + fruit.price);
                // Exception in thread "main" java.lang.ClassCastException: Fruit155 cannot be cast to java.lang.Comparable
                // Fruit155 클래스가 Comparable 인터페이스를 구현하지 않았고, compareTo() 메서드를 재정의하지 않았기 때문에 발생
            }
        } catch(Exception e) {}
        

        // Comparable 구현이 불가할 경우 - Comparator 사용하기
        TreeSet<Fruit155> treeSet2 = new TreeSet<>(new DescendingComparator());
        // TreeSet은 저장되는 객체의 정렬을 위해 별도로 Comparator 객체를 생성자 매개값으로 받음
        // -> 매개값으로 주어지는 Comparator 정렬자를 가지고 정렬하도록 기능 제공됨

        treeSet2.add(new Fruit155("포도", 3000));
        treeSet2.add(new Fruit155("딸기", 13000));
        treeSet2.add(new Fruit155("수박", 6000));
            
        Iterator<Fruit155> iterator2 = treeSet2.iterator();

        while(iterator2.hasNext()) {
            Fruit155 fruit = iterator2.next();
            System.out.println(fruit.name + " : " + fruit.price);
            /*
            딸기 : 13000
            수박 : 6000
            포도 : 3000
            */
        }
    }
}
