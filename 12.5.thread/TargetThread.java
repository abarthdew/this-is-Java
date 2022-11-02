public class TargetThread extends Thread {
    
    @Override
    public void run() {
        for (long i=0; i<1000000000; i++) {}
        
        Thread.sleep(1500);

        for(int i=0; i<100000000; i++) {}
    }

}