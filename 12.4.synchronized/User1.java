public class User1 extends Thread {
    
    private Cal124 cal;

    public void setCal(Cal124 cal) {
        this.setName("User1");
        this.cal = cal;
    }

    @Override
    public void run() {
        cal.setMemory(100);
    }

}
