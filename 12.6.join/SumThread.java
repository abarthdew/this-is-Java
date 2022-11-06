public class SumThread extends Thread {
    private long sum;

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        for(int i=0; i<=100; i++) {
            sum += i;
        }
    }
}
