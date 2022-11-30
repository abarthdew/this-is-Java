import java.util.Arrays;
import java.util.List;

public class FlatMapExam {
    public static void main(String[] args) {
        
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");

        inputList1.stream()
            .flatMap(data -> Arrays.stream(data.split(" "))) // "java8 lambda" 라는 하나의 요소를 공백 기준으로 java8, lambda로 분리하고, 이들을 요소로 가지는 스트림을 만듦
            // "java8 lambda"에서 2개의 단어, "stream mapping"에서 2개의 단어가 나오기 때문에,
            // flatMap이 리턴하는 중간 스트림은 요소가 4개인 스트림이 됨
            .forEach(word -> System.out.println(word)); // 요소를 하나씩 출력(4번 반복됨)
                /*
                java8
                lambda
                stream
                mapping
                */
        System.out.println();

        List<String> inputList2 = Arrays.asList("10,20,30", "40,50,60");
        inputList2.stream()
            .flatMapToInt(data -> {
                String[] strArray = data.split(",");
                int[] intArr = new int[strArray.length];
                for (int i=0; i<strArray.length; i++) {
                    intArr[i] = Integer.parseInt(strArray[i].trim());
                }
                return Arrays.stream(intArr);
            }).forEach(number -> System.out.println(number));
                /*
                10
                20
                30
                40
                50
                60
                 */
    }
}
