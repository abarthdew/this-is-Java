public class EnumExam {
    public static void main(String[] args) {
        Week today = null;
        today = Week.MONDAY;
        System.out.println(today); // MONDAY


        Week week = Week.MONDAY;
        String name = week.name();
        System.out.println(name); // MONDAY

        int ordinal = week.ordinal();
        System.out.println(ordinal); // 0

        Week day1 = Week.MONDAY;
        Week day2 = Week.TUESDAY;
        int result1 = day1.compareTo(day2); // -1
        System.out.println(result1);

        Week weekDay = Week.valueOf("SUNDAY");
        System.out.println(weekDay); // SUNDAY
        if (weekDay == Week.SUNDAY) {
            System.out.println("weekDay == Week.SUMDAY");
        } else {
            System.out.println("weekDay != Week.SUMDAY");
        }
        // weekDay == Week.SUMDAY

        Week[] days = Week.values();
        for (Week day: days) {
            System.out.println(day);
            /*
             MONDAY
            TUESDAY
            SUNDAY
             */
        }
    }
}
