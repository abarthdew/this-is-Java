import java.util.Arrays;
import java.util.Random;

public class RandomExam {
    public static void main(String[] args) {
        
        // 로또 번호 얻기
        // 선택번호
        int[] selectNum = new int[6];
        Random random = new Random();
        System.out.print("선택번호: ");
        for (int i=0; i<6; i++) {
            selectNum[i] = random.nextInt(45) + 1; // 1~45 까지의 임의의 정수
            System.out.print(selectNum[i] + " ");
        }
        System.out.println();
        // 선택번호: 39 19 30 13 11 22
        // 선택번호: 33 39 19 7 13 22 
        // .... (항상 다름)
        // 종자값이 없을 경우, 현재 시스템 시간을 이용해 난수를 만듬: 시간은 항상 다르기 때문에, 항상 다른 난수값 생성

        // 종자값이 같을 경우, 몇 번을 실행해도 결과는 같음
        random = new Random(3);
        System.out.print("선택번호: ");
        for (int i=0; i<6; i++) {
            selectNum[i] = random.nextInt(45) + 1; 
            System.out.print(selectNum[i] + " ");
        }
        System.out.println();
        // 선택번호: 15 21 16 17 34 28 (항상 같음)

        // 당첨 번호
        int[] winningNum = new int[6];
        random = new Random();
        System.out.print("당첨번호: ");
        for (int i=0; i<6; i++) {
            winningNum[i] = random.nextInt(45) + 1; 
            System.out.print(winningNum[i] + " ");
        }
        System.out.println();
        // 당첨번호: 44 22 2 18 31 22

        // 당첨 여부
        // 선택 번호와 당첨 번호 비교
        // 정렬 후 비교
        Arrays.sort(selectNum);
        Arrays.sort(winningNum);
        boolean result = Arrays.equals(selectNum, winningNum);
        System.out.println(result); // false(다르므로 false, 같으면 true)
    }
}
