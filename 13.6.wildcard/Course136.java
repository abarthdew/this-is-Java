public class Course136<T> {

  private String name;
  private T[] students; // 과정당 최대 학생수

  public Course136(String name, int capacity) {
    this.name = name;
    // students = new T[capacity]; // 컴파일 에러: T타입이 아직 결정되지 않았으므로 new T로 만들 수 없음
    students = (T[]) (new Object[capacity]); // 일단 new Object 배열로 만들고, T타입으로 강제 타입변환하면 T타입으로 만들 수 있음
  }

  public String getName() {
    return name;
  }

  public T[] getStudents() {
    return students;
  }

  public void add(T t) {
    for (int i = 0; i < students.length; i++) {
      if (students[i] == null) { // 배열 중간이 빌 경우 거기 값 넣음
        students[i] = t;
        break;
      }
    }
  }

}