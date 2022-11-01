public class User4 extends Thread {

    private Cal125 cal;

    public void setCal(Cal125 cal) {
        this.setName("User4");
        this.cal = cal;
    }

    @Override
    public void run() {
        cal.setMemory(50);
    }

}
