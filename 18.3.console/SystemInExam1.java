import java.io.InputStream;

import javax.print.attribute.standard.MediaSize.Other;

public class SystemInExam1 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("==메뉴==");
        System.out.println("1. 예금 조회");
        System.out.println("2. 예금 출금");
        System.out.println("3. 예금 입금");
        System.out.println("4. 종료하기");
        System.out.print("메뉴를 선택하세요: ");

        InputStream is = System.in;
        char intputChar = (char) is.read(); // read() 메서드로 1byte 읽음
        switch(intputChar) {
            case '1':
            System.out.println("예금 조회 선택");
            break;
            case '2':
            System.out.println("예금 출금 선택");
            break;
            case '3':
            System.out.println("예금 입금 선택");
            break;
            case '4':
            System.out.println("종료 선택");
            break;
        }

    }
}
