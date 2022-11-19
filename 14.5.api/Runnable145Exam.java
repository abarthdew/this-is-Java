public class Runnable145Exam {
    public static void main(String[] args) {
        
        Runnable runnable = () -> {
            for (int i=0; i<10; i++) {
                System.out.print(i + " ");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start(); // 0 1 2 3 4 5 6 7 8 9 

        System.out.println();

        thread = new Thread(() -> {
            for (int i=0; i<10; i++) {
                System.out.print(i + " ");
            }
        });
        thread.start(); // 0 1 2 3 4 5 6 7 8 9 

    }
}
