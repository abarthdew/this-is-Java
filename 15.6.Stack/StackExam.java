import java.util.Stack;

public class StackExam {
    public static void main(String[] args) {
        
        Stack<Coin> coinBox = new Stack<>();
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        while(!coinBox.isEmpty()) {
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
            /* (나중에 넣은 순서대로 나옴)
            꺼내온 동전: 10원
            꺼내온 동전: 500원
            꺼내온 동전: 50원
            꺼내온 동전: 100원
             */
        }

    }
}
