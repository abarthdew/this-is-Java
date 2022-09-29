public class Account2 {
    private long balance;
    public Account2() {}
    public long getBalance() {
        return balance;
    }
    public void deposit(int money) {
        balance += money;
    }
    public void withdraw(int money) throws BalanceInsufficientException2 {
        // 잔고 값보다 더 많은 출금을 요구할 경우 예외 발생
        if (balance < money) {
            throw new BalanceInsufficientException2("잔고부족: " + (money-balance) + " 모자람");
        }
        balance -= money;
    }
}
