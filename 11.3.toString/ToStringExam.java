import java.util.Date;

public class ToStringExam {
    public static void main(String[] args) {
        
        Object obj1 = new Object();
        Date obj2 = new Date();

        System.out.println(obj1); // java.lang.Object@15db9742
        System.out.println(obj2); // Sun Oct 02 21:26:47 KST 2022

    }
}
