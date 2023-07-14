import java.util.Objects;

public class HashExam {
  public static void main(String[] args) {
    Student s1 = new Student(1, "가");
    Student s2 = new Student(1, "가");
    Student s3 = new Student(1, "나");
    System.out.println(s1.hashCode()); // student의 hashCode(): 45024
    System.out.println(s2.hashCode()); // student의 hashCode(): 45024
    System.out.println(s3.hashCode()); // student의 hashCode(): 46200
    System.out.println(s1.equals(s2)); // student의 equals(): true
    System.out.println(s1.equals(s3)); // student의 equals(): false
  }

  static class Student {
    int sno;
    String name;

    Student(int sno, String name) {
      this.sno = sno;
      this.name = name;
    }

    @Override
    public int hashCode() {
      // return sno.hashCode();
      // return name.hashCode();
      // 위와 같이 따로 리턴하면 sno가 같은지, name과 같은지 따로 따져야 함
      // 두 필드의 값을 한꺼번에 비교하기 위해 각각의 필드가 전부 같으면 동일한 hashCode를 리턴하도록 재정의
      System.out.print("student의 hashCode(): ");
      return Objects.hash(sno, name); // sno, name이 같은 경우 동일한 객체로 간주
    }

    // 확실한 동등비교 추가
    @Override
    public boolean equals(Object obj) {
      System.out.print("student의 equals(): ");
      if (obj instanceof Student) {
        Student s = (Student) obj;
        if (s.sno == this.sno) {
          if (s.name.equals(this.name)) {
            return true;
          }
        }
      }
      return false;
    }
  }
}