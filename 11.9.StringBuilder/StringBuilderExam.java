public class StringBuilderExam {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("java ");
        sb.append("program study");
        System.out.println(sb.toString()); // java program study

        sb.insert(4, 2); // index 4위치에 2를 넣어라
        // 2는 문자열로 변화되어 추가됨
        System.out.println(sb.toString()); // java2 program study

        sb.setCharAt(4, '6');
        System.out.println(sb.toString()); // java6 program study

        sb.replace(6, 13, "Book"); // index 6~13 까지의 문자를 Book이라는 문자열로 대치
        System.out.println(sb.toString()); // java6 Book study

        sb.delete(4, 5); // index 4~5를 삭제

        int length = sb.length();
        System.out.println(length); // 15 // 총 문자수

        System.out.println(sb.toString()); // java Book study
    }
}
