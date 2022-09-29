public class AccountExam2 {
    public static void main(String[] args) {
        Account2 account = new Account2();

        // 예금하기
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance()); // 예금액: 10000

        // 출금하기
        try { // 예외 처리 코드가 반드시 있어야 컴파일 오류가 나지 않음
            account.withdraw(3000000);
            System.out.println("예금액: " + account.getBalance());
        } catch(BalanceInsufficientException2 e) {
            System.out.println("예외 발생"); // 예외 발생
            System.out.println(e.getMessage()); // 잔고부족: 2990000 모자람 // 정확하게 왜 예외가 발생했는지 알 수 있음
            e.printStackTrace();
            /*
            // 아래 내용이 출력되며, 이걸 보고 디버깅 가능
             BalanceInsufficientException2: 잔고부족: 2990000 모자람     
            at Account2.withdraw(Account2.java:13)
            at AccountExam2.main(AccountExam2.java:11)
             */
            System.out.println(e.toString()); // BalanceInsufficientException2: 잔고부족: 2990000 모자람 // 간단한 예외 발생 이유를 확인할 수 있음

            // 메세지 활용 용도
            String message = e.getMessage();
            if (message.equals("1004")) {
                // 예외처리1
            } else if (message.equals("1005")) {
                // 예외처리2
            } // 이런 식으로 여러 가지 예외를 각각 처리할 수 있음
        }
    }
}
