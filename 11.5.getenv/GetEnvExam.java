public class GetEnvExam {
    public static void main(String[] args) {
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(javaHome); // C:\Program Files\Java\jdk1.8.0_201
    }
}
