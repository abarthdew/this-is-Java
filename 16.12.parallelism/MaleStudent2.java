import java.util.ArrayList;
import java.util.List;

public class MaleStudent2 {
    
    private List<Student611> list;

    public MaleStudent2() {
        list = new ArrayList<Student611>();
        System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
    }

    public void accumulate(Student611 student) {
        list.add(student);
        System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
    }

    public void combine(MaleStudent2 other) { 
        list.addAll(other.getList()); 
        System.out.println("[" + Thread.currentThread().getName() + "] combine()");
    }

    public List<Student611> getList() {
        return list;
    }

}
