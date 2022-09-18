public class StudentExam {
    public static void main(String[] args) {
        Student student = new Student("홍길동", "123-456", 1);
        /*
         부모 객체 생성 완료
        자식 객체 생성 완료
         */
        System.out.println(student.name); // 물려받음 // 홍길동
        System.out.println(student.ssn); // 물려받음 // 123-456
        System.out.println(student.studentNo); // 자식 필드 // 1
    }
}
