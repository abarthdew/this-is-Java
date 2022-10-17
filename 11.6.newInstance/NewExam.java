public class NewExam {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("SendAction");
            try {
                Action action1 = (Action) clazz.newInstance();
                action1.execute(); // sendAction
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        
        try {
            Class clazz = Class.forName("RecieveAction");
            Action action2 = (Action) clazz.newInstance();
            action2.execute(); // recieveAction
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
