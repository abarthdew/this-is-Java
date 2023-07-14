public class AccountExam {
  public static void main(String[] args) {
    Account account = new Account();

    // 예금하기
    account.deposit(10000);
    System.out.println("예금액: " + account.getBalance()); // 예금액: 10000

    // 출금하기
    try { // 예외 처리 코드가 반드시 있어야 컴파일 오류가 나지 않음
      account.withdraw(3000000);
      System.out.println("예금액: " + account.getBalance());
    } catch (BalanceInsufficientException e) {
      System.out.println("예외 발생"); // 예외 발생
    }
  }
}
