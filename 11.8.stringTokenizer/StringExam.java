import java.util.StringTokenizer;

public class StringExam {
    public static void main(String[] args) {

        // split
        String text = "홍길동&이수홍,박연수,김자바-최명호";
        String[] names = text.split("&|,|-");
        for(String name : names) {
            System.out.println(name);
        }
        /*
         홍길동
        이수홍
        박연수
        김자바
        최명호
         */

        System.out.println("========");

        // tokenizer
        String text2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(text2, "/"); // 구분자는 하나만 가능
        int count = st.countTokens();
        for (int i=0; i<count; i++) {
            String token = st.nextToken();
            System.out.println(token);
        }
        /*
        홍길동
        이수홍
        박연수
         */

        System.out.println("========");

        // new StringTokenizer() 객체는 재사용이 불가능하므로 하나를 더 만들어 사용
        st = new StringTokenizer(text2, "/");
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
        /*
        홍길동
        이수홍
        박연수
         */
    }
}