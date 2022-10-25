import java.util.Calendar;

public class CalendarExam {
    public static void main(String[] args) {
        
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        System.out.println(year); // 2022
        System.out.println(month); // 10
        System.out.println(day); // 25

        int week = now.get(Calendar.DAY_OF_WEEK);
        System.out.println(week); // 3
        String strWeek = null;
        switch(week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SUNDAY:
                strWeek = "토";
                break;
        }
        System.out.println(strWeek); // 화

        int am_pm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if(am_pm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }
        System.out.println(strAmPm); // 오후

        int hour = now.get(Calendar.HOUR);
        int min = now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);
        System.out.println(hour); // 11
        System.out.println(min); // 4
        System.out.println(sec); // 22
    }
}
