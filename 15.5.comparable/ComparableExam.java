import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExam {
    public static void main(String[] args) {
        
        TreeSet<Person155> treeSet = new TreeSet<>();
        treeSet.add(new Person155("홍길동", 45));
        treeSet.add(new Person155("홍길동2", 25));
        treeSet.add(new Person155("홍길동3", 31));
        // 자동적으로 나이에 맞게 정렬됨

        Iterator<Person155> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Person155 person = iterator.next(); // Person155 클래스의 compareTo() 메서드가 재정의됨에 따라, 나이가 적은 순서대로 가져옴
            System.out.println(person.name + " : " + person.age);
            /**
            홍길동2 : 25
            홍길동3 : 31
            홍길동 : 45
             */
        }

    }
}
