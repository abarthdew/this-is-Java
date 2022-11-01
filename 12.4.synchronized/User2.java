public class User2 extends Thread {

    private Cal124 cal;

    public void setCal(Cal124 cal) {
        this.setName("User2");
        this.cal = cal;
    }

    @Override
    public void run() {
        cal.setMemory(50);
    }

}
