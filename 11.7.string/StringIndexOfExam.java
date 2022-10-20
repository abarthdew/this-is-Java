public class StringIndexOfExam {
    public static void main(String[] args) {
        
        // indexOf
        String subject = "자바 프로그래밍";
        int location = subject.indexOf("프로그래밍");
        System.out.println(location); // 3

        // length
        String ssn = "123456";
        System.out.println(ssn.length()); // 6

        // replace
        String oldStr = "자바는 객체 어쩌고";
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println(oldStr); // 자바는 객체 어쩌고
        System.out.println(newStr); // JAVA는 객체 어쩌고

        // substring
        String ssn2 = "123456789";
        System.out.println(ssn2.substring(0, 6)); // 123456
        System.out.println(ssn2.substring(7)); // 89

        // toLowerCase, toUpperCase
        String origin = "Java Programming";
        System.out.println(origin.toUpperCase()); // JAVA PROGRAMMING
        System.out.println(origin.toLowerCase()); // java programming

        // trim
        String exam = " abcde ff ";
        System.out.println(exam.trim()); // abcde ff

        // valueOf
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(true);
        String str3 = String.valueOf(10.5);
        System.out.println(str1); // 10
        System.out.println(str2); // true
        System.out.println(str3); // 10.5
        System.out.println(str1.length()); // 2
        System.out.println(str2.length()); // 4
        System.out.println(str3.length()); // 4
    }
}