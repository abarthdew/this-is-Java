import java.util.ArrayList;
import java.util.List;

public class MaleStudent {

  private List<Student611> list;

  public MaleStudent() {
    list = new ArrayList<Student611>();
    System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
  }

  public void accumulate(Student611 student) {
    list.add(student);
    System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
  }

  public void combine(MaleStudent other) { // 다른 컨테이너를 매개값으로 받아
    list.addAll(other.getList()); // 해당 컨테이너 안에 있는 내용을 모두 list 객체에 추가(결합)
    System.out.println("[" + Thread.currentThread().getName() + "] combine()");
  }

  public List<Student611> getList() {
    return list;
  }

}
