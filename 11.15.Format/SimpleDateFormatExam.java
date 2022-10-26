import java.util.Date;
import java.text.SimpleDateFormat;

public class SimpleDateFormatExam {
    public static void main(String[] args) {
        
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(now)); // 2022-10-26 10:04:27
        
        sdf = new SimpleDateFormat("E 요일");
        System.out.println(sdf.format(now)); // 수 요일

        sdf = new SimpleDateFormat("올해 D 번째 날");
        System.out.println(sdf.format(now)); // 올해 299 번째 날

        sdf = new SimpleDateFormat("이달 d 번째 날");
        System.out.println(sdf.format(now)); // 이달 26 번째 날


    }
}
