import java.util.Comparator;
import java.util.Objects; // java.lang을 제외한 util 등은 import 필수

public class CompareExam {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        // int result = Objects.compare(s1, s2, new Comparator<Student>() {
        //     // 이렇게 익명 클래스로 만들어도 됨
        // });
        int result1 = Objects.compare(s1, s2, new StudentComparator());
        System.out.println(result1); // 0
        int result2 = Objects.compare(s1, s3, new StudentComparator());
        System.out.println(result2); // -1
    }

    static class Student {
        int sno;
        Student(int sno) {
            this.sno = sno;
        }
    }

    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(CompareExam.Student a, CompareExam.Student b) {
            // if (a.sno < b.sno) return -1;
            // else if (a.sno == b.sno) return 0;
            // else return 1;
            return Integer.compare(a.sno, b.sno);
            // 위와 결과 같음
        }
    }
}