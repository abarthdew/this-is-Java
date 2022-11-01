public class User3 extends Thread {
    
    private Cal125 cal;

    public void setCal(Cal125 cal) {
        this.setName("User3");
        this.cal = cal;
    }

    @Override
    public void run() {
        cal.setMemory(100);
    }

}
