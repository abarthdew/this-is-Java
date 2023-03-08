public class SingletonExam {
    public static void main(String[] args) {
        // Singleton singleton1 = new Singleton(); // 컴파일 에러

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2); // true
    }
}
