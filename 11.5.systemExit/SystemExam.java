public class SystemExam {
    public static void main(String[] args) {

        // 특정Override료되도록 할 때
        System.setSecurityManager(new SecurityManager() {
            @Override
           public void  checkExit(int status) {
            System.out.println("checkExit() 실행: ");
                if (status != 5) {
                    throw new SecurityException();
                }
            }
        }); // exit()가 실행되면, checkExit가 자동으로 실행됨
        
        for(int i=0; i<10; i++) {
            System.out.println(i);
            /*
            0
            checkExit() 실행:
            1
            checkExit() 실행: 
            2
            checkExit() 실행: 
            3
            checkExit() 실행: 
            4
            checkExit() 실행: 
            5
            checkExit() 실행: 
             */
            try {
                System.exit(i); 
            } catch(SecurityException e) {

            }
        }
    }
}