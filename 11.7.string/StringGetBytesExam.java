import java.io.UnsupportedEncodingException;

public class StringGetBytesExam {
    public static void main(String[] args) {
        
        String str1 = "안녕하세요";
        String str2 = "HELLO";
        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str2.getBytes();
        System.out.println(bytes1.length); // 10 (한글은 한 글자에 2 바이트 차지)
        System.out.println(bytes2.length); // 5 (영어는 한 글자에 1 바이트 차지)

        // 바이트 배열을 문자열로 복원
        String str3 = new String(str1);
        System.out.println(str3); // 안녕하세요

        try {
            byte[] bytes4 = str1.getBytes("EUC-KR");
            System.out.println(bytes4.length); // 10 
            String str4 = new String(bytes4, "EUC-KR");
            System.out.println(str4); // 안녕하세요

            byte[] bytes5 = str1.getBytes("UTF-8");
            System.out.println(bytes5.length); // 15 (UTF-8 인코딩은 한글을 한 글자에 3 바이트로 표현)
            String str5 = new String(bytes5, "EUC-KR");
            System.out.println(str5); // ???????몄?? (UTF-8[3바이트 해석] -> EUC-KR[2바이트 해석]: 깨짐)
            String str6 = new String(bytes5);
            System.out.println(str6); // ?븞?뀞?븯?꽭?슂 (UTF-8 인코딩한 그대로 출력해도 깨지는 이유: default 문자 셋이 EUC-KR과 동일하기 때문에)
            String str7 = new String(bytes5, "UTF-8");
            System.out.println(str7); // 안녕하세요 (UTF-8로 인코딩 해 줘야 함)
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
