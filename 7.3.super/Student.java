public class Student extends People {

    public int studentNo;

    public Student(String name, String ssn, int studentNo) {
        // super(); // 부모인 People에 기본 생성자가 없으므로 컴파일 오류
        super(name, ssn); // 부모 클래스에 기본 생성자가 없는 경우 필수
        this.studentNo = studentNo;
        System.out.println("자식 객체 생성 완료");
    }
    
}
