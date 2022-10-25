import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1); // Tue Oct 25 22:55:56 KST 2022

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm 분 ss초");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2); // 2022년 10월 25일 10시 55 분 56초

    }
}
