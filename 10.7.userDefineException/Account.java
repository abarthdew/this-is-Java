public class Account {
  private long balance;

  public Account() {
  }

  public long getBalance() {
    return balance;
  }

  public void deposit(int money) {
    balance += money;
  }

  public void withdraw(int money) throws BalanceInsufficientException {
    // 잔고 값보다 더 많은 출금을 요구할 경우 예외 발생
    if (balance < money) {
      throw new BalanceInsufficientException();
    }
    balance -= money;
  }
}
