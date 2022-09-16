public class PersonExam {
    public static void main(String[] args) {
        Person person = new Person("123-456", "이름1");

        System.out.println(person.nation);
        System.out.println(person.ssn);
        System.out.println(person.name);

        // person.nation = "usa"; // 다른 값 대입 불가
        // person.ssn = "456-456" // 다른 값 대입 불가
        person.name = "개명";
    }
}
